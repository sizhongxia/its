package com.dm.stu.app;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dm.stu.service.UserService;

@Controller
public class AppController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	UserService userService;

	@GetMapping("index")
	public String index(Map<String, Object> data) {
		return "index";
	}


	@GetMapping("login")
	public String login(Map<String, Object> data) {
		return "login";
	}

//	@ResponseBody
//	@GetMapping("/uid/{uid}")
//	String uid(@PathVariable("uid") String userId, HttpSession session) {
//		UUID uid = (UUID) session.getAttribute(userId);
//		if (uid == null) {
//			uid = UUID.randomUUID();
//		}
//		session.setAttribute(userId, uid);
//		return session.getId();
//	}
//
//	@ResponseBody
//	@GetMapping("/rmuid/{uid}")
//	String rmuid(@PathVariable("uid") String userId, HttpSession session) {
//		UUID uid = (UUID) session.getAttribute(userId);
//		if (uid != null) {
//			session.removeAttribute(userId);
//		}
//		return userId;
//	}
}
