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

import com.dm.stu.domain.Menu;
import com.dm.stu.model.ResponseData;
import com.dm.stu.service.TxJurisdictionService;
import com.dm.stu.util.PublicUtil;
import com.dm.stu.util.SecurityUtil;

@RestController
@RequestMapping("tx.menu")
public class TxMenuController {

	@Autowired
	TxJurisdictionService txJurisdictionService;

	@GetMapping("get-by-id")
	public ResponseData getById(String menuId) {
		if (PublicUtil.isEmpty(menuId)) {
			return new ResponseData(10001, "无效的表单参数");
		}
		// 解密
		menuId = SecurityUtil.AESDecrypt(menuId);
		if (menuId == null) {
			return new ResponseData(10002, "无效的参数");
		}
		Menu m = txJurisdictionService.getMenuById(menuId);
		if (m == null) {
			return new ResponseData(10003, "未找到数据，记录可能已被删除");
		}
		return new ResponseData(transform(m));
	}

	@GetMapping("get-parent-menus")
	public ResponseData getParentMenus() {
		List<Menu> menus = txJurisdictionService.getParentMenus();
		List<Map<String, Object>> list = new ArrayList<>();
		if (!PublicUtil.isEmpty(menus)) {
			for (Menu m : menus) {
				list.add(transform(m));
			}
		}
		return new ResponseData(list);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("get-all")
	public ResponseData getAll() {
		List<Menu> menus = txJurisdictionService.getAllMenus();
		List<Map<String, Object>> list = new ArrayList<>();
		if (PublicUtil.isEmpty(menus)) {
			return new ResponseData(list);
		}
		// 获取根节点
		for (Menu p : menus) {
			if (PublicUtil.isEmpty(p.getMenuPid())) {
				Map<String, Object> root = transform(p);
				root.put("type", "parent");
				root.put("children", new ArrayList<Map<String, Object>>());
				list.add(root);
			}
		}
		if (!list.isEmpty()) {
			for (Map<String, Object> map : list) {
				String pid = SecurityUtil.AESDecrypt(map.get("menuId").toString());
				if (pid == null) {
					continue;
				}
				for (Menu p : menus) {
					if (p.getMenuPid() != null && pid.equals(p.getMenuPid())) {
						Map<String, Object> child = transform(p);
						child.put("type", "child");
						((List<Map<String, Object>>) map.get("children")).add(child);
					}
				}
			}
		}
		return new ResponseData(list);
	}

	@PostMapping("save")
	public ResponseData save(@RequestBody Menu menu) {
		if (menu == null) {
			return new ResponseData(10001, "无效的参数");
		}
		String pid = menu.getMenuPid();
		if (!PublicUtil.isEmpty(pid)) {
			pid = SecurityUtil.AESDecrypt(pid);
			if (pid == null) {
				return new ResponseData(10002, "无效的菜单父级ID");
			}
			menu.setMenuPid(pid);
		}
		if (PublicUtil.isEmpty(menu.getMenuName())) {
			return new ResponseData(10003, "请输入菜单名称");
		}
		if (PublicUtil.isEmpty(menu.getMenuIcon())) {
			return new ResponseData(10004, "请选择菜单图标");
		}
		if (PublicUtil.isEmpty(menu.getMenuPrefix())) {
			return new ResponseData(10005, "请输入菜单前缀");
		}
		if (PublicUtil.isEmpty(menu.getMenuUiSref())) {
			return new ResponseData(10006, "请输入菜单路径");
		}
		if (menu.getMenuSerialNumber() == null) {
			return new ResponseData(10007, "请输入菜单序号");
		}
		if (menu.getMenuStatus() == null) {
			return new ResponseData(10008, "请选择菜单状态");
		}
		menu.setMenuId(PublicUtil.id());
		txJurisdictionService.save(menu);
		return new ResponseData(transform(menu));
	}

	@PostMapping("update")
	public ResponseData update(@RequestBody Menu menu) {
		if (menu == null) {
			return new ResponseData(10001, "无效的参数");
		}
		String menuId = menu.getMenuId();
		if (PublicUtil.isEmpty(menuId)) {
			return new ResponseData(10002, "无效的表单参数");
		}
		// 解密
		menuId = SecurityUtil.AESDecrypt(menuId);
		if (menuId == null) {
			return new ResponseData(10003, "无效的表单参数");
		}
		String pid = menu.getMenuPid();
		if (!PublicUtil.isEmpty(pid)) {
			pid = SecurityUtil.AESDecrypt(pid);
			if (pid == null) {
				return new ResponseData(10011, "无效的菜单父级ID");
			}
			if (pid.equals(menuId)) {
				return new ResponseData(10011, "不可选择自身节点为父级节点");
			}
			List<Menu> menus = txJurisdictionService.getMenuByParentId(pid);
			if (menus != null && !menus.isEmpty()) {
				return new ResponseData(10012, "父级菜单不可直接设置为子菜单，请先移除当前节点的子菜单");
			}
		}
		if (PublicUtil.isEmpty(menu.getMenuName())) {
			return new ResponseData(10004, "请输入菜单名称");
		}
		if (PublicUtil.isEmpty(menu.getMenuIcon())) {
			return new ResponseData(10005, "请选择菜单图标");
		}
		if (PublicUtil.isEmpty(menu.getMenuPrefix())) {
			return new ResponseData(10006, "请输入菜单前缀");
		}
		if (PublicUtil.isEmpty(menu.getMenuUiSref())) {
			return new ResponseData(10007, "请输入菜单路径");
		}
		if (menu.getMenuSerialNumber() == null) {
			return new ResponseData(10008, "请输入菜单序号");
		}
		if (menu.getMenuStatus() == null) {
			return new ResponseData(10009, "请选择菜单状态");
		}
		Menu u_menu = txJurisdictionService.getMenuById(menuId);
		if (u_menu == null) {
			return new ResponseData(10010, "未找到数据，记录可能已被删除");
		}
		if (PublicUtil.isEmpty(pid)) {
			pid = null;
		}
		u_menu.setMenuPid(pid);
		u_menu.setMenuName(menu.getMenuName());
		u_menu.setMenuIcon(menu.getMenuIcon());
		u_menu.setMenuPrefix(menu.getMenuPrefix());
		u_menu.setMenuSerialNumber(menu.getMenuSerialNumber());
		u_menu.setMenuStatus(menu.getMenuStatus());
		u_menu.setMenuUiSref(menu.getMenuUiSref());
		txJurisdictionService.update(u_menu);
		return new ResponseData(transform(u_menu));
	}

	@PostMapping("delete")
	public ResponseData delete(@RequestBody Menu menu) {
		if (menu == null) {
			return new ResponseData(10001, "无效的参数");
		}
		String menuId = menu.getMenuId();
		if (PublicUtil.isEmpty(menuId)) {
			return new ResponseData(10002, "无效的表单参数");
		}
		// 解密
		menuId = SecurityUtil.AESDecrypt(menuId);
		if (menuId == null) {
			return new ResponseData(10003, "无效的表单参数");
		}
		Menu smenu = txJurisdictionService.getMenuById(menuId);
		if (smenu == null) {
			return new ResponseData(10004, "未找到数据，记录可能已被删除");
		}
		txJurisdictionService.deleteMenu(menuId);
		return new ResponseData();
	}

	private Map<String, Object> transform(Menu m) {
		Map<String, Object> obj = new HashMap<>();
		obj.put("menuId", SecurityUtil.AESEncrypt(m.getMenuId()));
		if (m.getMenuPid() != null) {
			obj.put("menuPid", SecurityUtil.AESEncrypt(m.getMenuPid()));
		}
		obj.put("menuName", m.getMenuName());
		obj.put("menuIcon", m.getMenuIcon());
		obj.put("menuPrefix", m.getMenuPrefix());
		obj.put("menuSerialNumber", m.getMenuSerialNumber());
		obj.put("menuStatus", m.getMenuStatus());
		obj.put("menuUiSref", m.getMenuUiSref());
		return obj;
	}
}
