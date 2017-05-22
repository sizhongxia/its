package com.dm.stu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.stu.domain.Permission;
import com.dm.stu.model.ResponseData;
import com.dm.stu.service.TxJurisdictionService;
import com.dm.stu.util.PublicUtil;

@RestController
@RequestMapping("tx.permission")
public class TxPermissionController {

	@Autowired
	TxJurisdictionService txJurisdictionService;

	@GetMapping("get-by-id")
	public ResponseData getById(String permissionId) {
		if (PublicUtil.isEmpty(permissionId)) {
			return new ResponseData(10001, "无效的参数");
		}
		Permission permission = txJurisdictionService.getPermissionById(permissionId);
		if (permission == null) {
			return new ResponseData(10002, "无效的权限字ID");
		}
		return new ResponseData(permission);
	}

	@GetMapping("get-all")
	public ResponseData getAll() {
		List<Permission> permissions = txJurisdictionService.getAllPermissions();
		if (PublicUtil.isEmpty(permissions)) {
			return new ResponseData(10001, "无权限字数据");
		}
		return new ResponseData(permissions);
	}

	@PostMapping("save")
	public ResponseData save(@RequestBody Permission permission) {
		if (permission == null) {
			return new ResponseData(10001, "无效的参数");
		}
		if (PublicUtil.isEmpty(permission.getPermissionName())) {
			return new ResponseData(10002, "请输入权限字名称");
		}
		if (PublicUtil.isEmpty(permission.getPermissionCode())) {
			return new ResponseData(10003, "请输入权限字编码");
		}
		if (PublicUtil.isEmpty(permission.getPermissionDescript())) {
			return new ResponseData(10004, "请输入权限字描述");
		}
		Permission s_permission = txJurisdictionService.getPermissionByCode(permission.getPermissionCode());
		if (s_permission != null) {
			return new ResponseData(10005, "权限字编码已存在");
		}
		permission.setPermissionId(PublicUtil.id());
		txJurisdictionService.save(permission);
		return new ResponseData(permission);
	}

	@PostMapping("update")
	public ResponseData update(@RequestBody Permission permission) {
		if (permission == null) {
			return new ResponseData(10001, "无效的参数");
		}
		if (PublicUtil.isEmpty(permission.getPermissionId())) {
			return new ResponseData(10002, "无效的表单数据");
		}
		if (PublicUtil.isEmpty(permission.getPermissionName())) {
			return new ResponseData(10003, "请输入权限字名称");
		}
		if (PublicUtil.isEmpty(permission.getPermissionCode())) {
			return new ResponseData(10003, "请输入权限字编码");
		}
		if (PublicUtil.isEmpty(permission.getPermissionDescript())) {
			return new ResponseData(10004, "请输入权限字描述");
		}
		Permission u_permission = txJurisdictionService.getPermissionById(permission.getPermissionId());
		if (u_permission == null) {
			return new ResponseData(10005, "无效的权限字ID");
		}
		Permission s_permission = txJurisdictionService.getPermissionByCode(permission.getPermissionCode());
		if (s_permission != null && !s_permission.getPermissionId().equals(u_permission.getPermissionId())) {
			return new ResponseData(10006, "权限字名称已存在");
		}
		u_permission.setPermissionName(permission.getPermissionName());
		u_permission.setPermissionCode(permission.getPermissionCode());
		u_permission.setPermissionDescript(permission.getPermissionDescript());
		txJurisdictionService.update(u_permission);
		return new ResponseData(u_permission);
	}

	@PostMapping("delete")
	public ResponseData delete(String permissionId) {
		if (PublicUtil.isEmpty(permissionId)) {
			return new ResponseData(10001, "无效的权限字ID");
		}
		Permission permission = txJurisdictionService.getPermissionById(permissionId);
		if (permission == null) {
			return new ResponseData(10002, "无效的权限字ID");
		}
		return new ResponseData(permission);
	}

}
