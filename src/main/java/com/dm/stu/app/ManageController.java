package com.dm.stu.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("zx.m")
// @PreAuthorize("hasRole('user')")
public class ManageController {

	private final String PATH_PREFIX = "zx.m/";

	// ------------------------------
	// 主页面
	// ------------------------------
	@GetMapping("index")
	public String index() {
		return PATH_PREFIX + "index";
	}

	@GetMapping("main")
	public String main() {
		return PATH_PREFIX + "main";
	}

	// ------------------------------
	// 通用页面
	// ------------------------------
	@GetMapping("header")
	public String header() {
		return PATH_PREFIX + "template/header";
	}

	@GetMapping("footer")
	public String footer() {
		return PATH_PREFIX + "template/footer";
	}

	@GetMapping("sidebar-left")
	public String sidebarLeft() {
		return PATH_PREFIX + "template/sidebar-left";
	}

	@GetMapping("sidebar-right")
	public String sidebarRight() {
		return PATH_PREFIX + "template/sidebar-right";
	}

	@GetMapping("common")
	public String system() {
		return PATH_PREFIX + "template/common";
	}

	// ------------------------------
	// 系统权限相关页面
	// ------------------------------
	@GetMapping("system-role")
	public String systemRole() {
		return PATH_PREFIX + "system/role";
	}

	@GetMapping("system-permission-wd")
	public String systemPermissionWd() {
		return PATH_PREFIX + "system/permission-wd";
	}

	@GetMapping("system-permission-wd-create")
	public String systemPermissionWdCreate() {
		return PATH_PREFIX + "system/permission-wd-create";
	}

	@GetMapping("system-permission-group")
	public String systemPermissionGroup() {
		return PATH_PREFIX + "system/permission-group";
	}

	@GetMapping("system-menu")
	public String systemMenu() {
		return PATH_PREFIX + "system/menu";
	}
}
