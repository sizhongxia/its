package com.dm.stu.app;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dm.stu.domain.User;
import com.dm.stu.service.UserService;
import com.dm.stu.util.PublicUtil;
import com.dm.stu.util.SecurityUtil;

@Controller
public class AppController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	RedisTemplate<String, String> redisTemplate;
	@Autowired
	UserService userService;

	@GetMapping("index")
	public String index(Map<String, Object> data) {
		return "index";
	}

	@GetMapping("login")
	public String login(Map<String, Object> data) {
		Object phoneNumber = data.get("LoginAccount");
		if (phoneNumber != null) {
			String key = "shiro:login:disable_falg:account_" + phoneNumber;
			long seconds = redisTemplate.getExpire(key, TimeUnit.SECONDS);
			if (seconds > 0) {
				data.put("DISABLE_LEFT_TIME", PublicUtil.toTextTime(seconds));
			}
		}

		return "login";
	}

	@PostMapping("/login")
	public String login(User user, RedirectAttributes redirectAttributes) {
		String phoneNumber = user.getPhoneNumber();
		if (PublicUtil.isEmpty(phoneNumber)) {
			redirectAttributes.addFlashAttribute("message", "请输入手机号");
			return "redirect:/login";
		}
		if (PublicUtil.isEmpty(user.getPassword())) {
			redirectAttributes.addFlashAttribute("message", "请输入密码");
			return "redirect:/login";
		}
		logger.debug(phoneNumber + " > Login.");
		UsernamePasswordToken token = new UsernamePasswordToken(phoneNumber, SecurityUtil.md5(user.getPassword()));
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			redirectAttributes.addFlashAttribute("message", "未知账户");
		} catch (IncorrectCredentialsException ice) {
			redirectAttributes.addFlashAttribute("message", "密码不正确(" + ice.getMessage() + ")");
		} catch (LockedAccountException lae) {
			redirectAttributes.addFlashAttribute("message", "账户已锁定");
		} catch (DisabledAccountException dae) {
			redirectAttributes.addFlashAttribute("message", "账号未激活");
		} catch (ExcessiveAttemptsException eae) {
			redirectAttributes.addFlashAttribute("LoginAccount", phoneNumber);
			redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			return "redirect:/zx.m/index";
		} else {
			token.clear();
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	public String logout(RedirectAttributes redirectAttributes) {
		SecurityUtils.getSubject().logout();
		redirectAttributes.addFlashAttribute("message", "您已安全退出");
		return "redirect:/login";
	}

	//
	// @ResponseBody
	// @GetMapping("/rmuid/{uid}")
	// String rmuid(@PathVariable("uid") String userId, HttpSession session) {
	// UUID uid = (UUID) session.getAttribute(userId);
	// if (uid != null) {
	// session.removeAttribute(userId);
	// }
	// return userId;
	// }
}
