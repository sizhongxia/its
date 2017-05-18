package com.dm.stu.app;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("main")
	public String main(Map<String, Object> data) {
		return "main";
	}

	@GetMapping("login")
	public String login(Map<String, Object> data) {
		return "login";
	}

	@GetMapping("upload-file")
	public String uploadFile(Map<String, Object> data) {
		return "upload-file";
	}

	@ResponseBody
	@GetMapping("/uid/{uid}")
	String uid(@PathVariable("uid") String userId, HttpSession session) {
		UUID uid = (UUID) session.getAttribute(userId);
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute(userId, uid);
		return session.getId();
	}

	@ResponseBody
	@GetMapping("/rmuid/{uid}")
	String rmuid(@PathVariable("uid") String userId, HttpSession session) {
		UUID uid = (UUID) session.getAttribute(userId);
		if (uid != null) {
			session.removeAttribute(userId);
		}
		return userId;
	}
}
