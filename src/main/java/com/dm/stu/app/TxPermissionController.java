package com.dm.stu.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.dm.stu.util.SecurityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("tx.permission")
public class TxPermissionController {

	@Autowired
	TxJurisdictionService txJurisdictionService;

	@GetMapping("get-by-id")
	public ResponseData getById(String permissionId) {
		if (PublicUtil.isEmpty(permissionId)) {
			return new ResponseData(10001, "无效的表单参数");
		}
		// 解密
		permissionId = SecurityUtil.AESDecrypt(permissionId);
		if (permissionId == null) {
			return new ResponseData(10002, "无效的参数");
		}
		Permission p = txJurisdictionService.getPermissionById(permissionId);
		if (p == null) {
			return new ResponseData(10003, "未找到数据，记录可能已被删除");
		}
		return new ResponseData(transform(p));
	}

	@GetMapping("get-by-page")
	public ResponseData getByPage(String page, String perPage) {
		int ipage = PublicUtil.toInteger(page);
		int iperPage = PublicUtil.toInteger(perPage);
		if (ipage < 1) {
			ipage = 1;
		}
		if (ipage < 1) {
			ipage = 20;
		}
		PageHelper.startPage(ipage, iperPage);
		List<Permission> permissions = txJurisdictionService.getAllPermissions();
		PageInfo<Permission> pageInfo = new PageInfo<Permission>(permissions);
		Map<String, Object> data = new HashMap<>();
		List<Map<?, ?>> list = new ArrayList<>();
		if (PublicUtil.isEmpty(permissions)) {
			return new ResponseData(list);
		}
		for (Permission p : permissions) {
			list.add(transform(p));
		}
		data.put("list", list);
		data.put("totalItems", pageInfo.getTotal());
		return new ResponseData(data);
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
		return new ResponseData(transform(permission));
	}

	@PostMapping("update")
	public ResponseData update(@RequestBody Permission permission) {
		if (permission == null) {
			return new ResponseData(10001, "无效的参数");
		}
		String permissionId = permission.getPermissionId();
		if (PublicUtil.isEmpty(permissionId)) {
			return new ResponseData(10002, "无效的表单参数");
		}
		// 解密
		permissionId = SecurityUtil.AESDecrypt(permissionId);
		if (permissionId == null) {
			return new ResponseData(10003, "无效的表单参数");
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
		Permission u_permission = txJurisdictionService.getPermissionById(permissionId);
		if (u_permission == null) {
			return new ResponseData(10005, "无效的权限字ID");
		}
		Permission s_permission = txJurisdictionService.getPermissionByCode(permission.getPermissionCode());
		if (s_permission != null && !s_permission.getPermissionId().equals(u_permission.getPermissionId())) {
			return new ResponseData(10006, "权限字编码已存在");
		}
		u_permission.setPermissionName(permission.getPermissionName());
		u_permission.setPermissionCode(permission.getPermissionCode());
		u_permission.setPermissionDescript(permission.getPermissionDescript());
		txJurisdictionService.update(u_permission);
		return new ResponseData(transform(u_permission));
	}

	@PostMapping("delete")
	public ResponseData delete(@RequestBody Permission permission) {
		if (permission == null) {
			return new ResponseData(10001, "无效的参数");
		}
		String permissionId = permission.getPermissionId();
		if (PublicUtil.isEmpty(permissionId)) {
			return new ResponseData(10002, "无效的表单参数");
		}
		// 解密
		permissionId = SecurityUtil.AESDecrypt(permissionId);
		if (permissionId == null) {
			return new ResponseData(10003, "无效的表单参数");
		}
		Permission spermission = txJurisdictionService.getPermissionById(permissionId);
		if (spermission == null) {
			return new ResponseData(10004, "未找到数据，记录可能已被删除");
		}
		txJurisdictionService.deletePermission(permissionId);
		return new ResponseData();
	}

	private Map<String, Object> transform(Permission p) {
		Map<String, Object> obj = new HashMap<>();
		obj.put("permissionId", SecurityUtil.AESEncrypt(p.getPermissionId()));
		obj.put("permissionName", p.getPermissionName());
		obj.put("permissionCode", p.getPermissionCode());
		obj.put("permissionDescript", p.getPermissionDescript());
		return obj;
	}
}
