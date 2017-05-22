package com.dm.stu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.stu.domain.Role;
import com.dm.stu.model.ResponseData;
import com.dm.stu.service.TxJurisdictionService;
import com.dm.stu.util.PublicUtil;

@RestController
@RequestMapping("tx.role")
public class TxRoleController {

	@Autowired
	TxJurisdictionService txJurisdictionService;

	@GetMapping("get-by-id")
	public ResponseData getById(String roleId) {
		if (PublicUtil.isEmpty(roleId)) {
			return new ResponseData(10001, "无效的参数");
		}
		Role role = txJurisdictionService.getRoleById(roleId);
		if (role == null) {
			return new ResponseData(10002, "无效的角色ID");
		}
		return new ResponseData(role);
	}

	@GetMapping("get-all")
	public ResponseData getAll() {
		List<Role> roles = txJurisdictionService.getAllRoles();
		if (PublicUtil.isEmpty(roles)) {
			return new ResponseData(10001, "无角色数据");
		}
		return new ResponseData(roles);
	}

	@PostMapping("save")
	public ResponseData save(@RequestBody Role role) {
		if (role == null) {
			return new ResponseData(10001, "无效的参数");
		}
		if (PublicUtil.isEmpty(role.getRoleName())) {
			return new ResponseData(10002, "请输入角色名称");
		}
		if (PublicUtil.isEmpty(role.getRoleDescript())) {
			return new ResponseData(10003, "请输入角色描述");
		}
		Role s_role = txJurisdictionService.getRoleByName(role.getRoleName());
		if (s_role != null) {
			return new ResponseData(10004, "角色名称已存在");
		}
		role.setRoleId(PublicUtil.id());
		txJurisdictionService.save(role);
		return new ResponseData(role);
	}

	@PostMapping("update")
	public ResponseData update(@RequestBody Role role) {
		if (role == null) {
			return new ResponseData(10001, "无效的参数");
		}
		if (PublicUtil.isEmpty(role.getRoleId())) {
			return new ResponseData(10002, "无效的表单数据");
		}
		if (PublicUtil.isEmpty(role.getRoleName())) {
			return new ResponseData(10003, "请输入角色名称");
		}
		if (PublicUtil.isEmpty(role.getRoleDescript())) {
			return new ResponseData(10004, "请输入角色描述");
		}
		Role u_role = txJurisdictionService.getRoleById(role.getRoleId());
		if (u_role == null) {
			return new ResponseData(10005, "无效的角色ID");
		}
		Role s_role = txJurisdictionService.getRoleByName(role.getRoleName());
		if (s_role != null && !s_role.getRoleId().equals(u_role.getRoleId())) {
			return new ResponseData(10006, "角色名称已存在");
		}
		u_role.setRoleName(role.getRoleName());
		u_role.setRoleDescript(role.getRoleDescript());
		txJurisdictionService.update(u_role);
		return new ResponseData(u_role);
	}

	@PostMapping("delete")
	public ResponseData delete(String roleId) {
		if (PublicUtil.isEmpty(roleId)) {
			return new ResponseData(10001, "无效的角色ID");
		}
		Role role = txJurisdictionService.getRoleById(roleId);
		if (role == null) {
			return new ResponseData(10002, "无效的角色ID");
		}
		return new ResponseData(role);
	}

}
