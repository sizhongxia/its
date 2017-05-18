package com.dm.stu.app;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("m")
@PreAuthorize("hasRole('user')")
public class ManageController {
	@GetMapping("index")
	public String index(Map<String, Object> data) {
		return "manage/index";
	}
}
