package com.dm.stu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.stu.dao.MenuMapper;
import com.dm.stu.dao.PermissionGroupMapper;
import com.dm.stu.dao.PermissionMapper;
import com.dm.stu.dao.RoleMapper;
import com.dm.stu.domain.Menu;
import com.dm.stu.domain.MenuExample;
import com.dm.stu.domain.Permission;
import com.dm.stu.domain.PermissionExample;
import com.dm.stu.domain.PermissionGroup;
import com.dm.stu.domain.PermissionGroupExample;
import com.dm.stu.domain.Role;
import com.dm.stu.domain.RoleExample;
import com.dm.stu.service.TxJurisdictionService;
import com.dm.stu.util.PublicUtil;

@Service
public class TxJurisdictionServiceImpl implements TxJurisdictionService {

	@Autowired
	RoleMapper roleMapper;
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	PermissionGroupMapper permissionGroupMapper;

	@Override
	public void save(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public Role getRoleById(String roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public Role getRoleByName(String roleName) {
		RoleExample example = new RoleExample();
		example.createCriteria().andRoleNameEqualTo(roleName);
		List<Role> roles = roleMapper.selectByExample(example);
		return PublicUtil.isEmpty(roles) ? null : roles.get(0);
	}

	@Override
	public void update(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public void deleteRole(String roleId) {
		roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public List<Role> getAllRoles() {
		RoleExample example = new RoleExample();
		example.setOrderByClause("role_name asc");
		return roleMapper.selectByExample(example);
	}

	@Override
	public void save(Menu menu) {
		menuMapper.insert(menu);
	}

	@Override
	public Menu getMenuById(String menuId) {
		return menuMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public void update(Menu menu) {
		menuMapper.updateByPrimaryKey(menu);
	}

	@Override
	public void deleteMenu(String menuId) {
		menuMapper.deleteByPrimaryKey(menuId);
	}

	@Override
	public List<Menu> getAllMenus() {
		MenuExample example = new MenuExample();
		example.setOrderByClause("menu_serial_number asc, menu_name asc");
		return menuMapper.selectByExample(example);
	}

	@Override
	public List<Menu> getMenuByParentId(String menuPid) {
		MenuExample example = new MenuExample();
		example.createCriteria().andMenuPidEqualTo(menuPid);
		example.setOrderByClause("menu_serial_number asc, menu_name asc");
		return menuMapper.selectByExample(example);
	}

	/**
	 * 获取所有父级菜单信息
	 */
	@Override
	public List<Menu> getParentMenus() {
		MenuExample example = new MenuExample();
		example.createCriteria().andMenuPidIsNull();
		example.setOrderByClause("menu_serial_number asc, menu_name asc");
		return menuMapper.selectByExample(example);
	}

	@Override
	public void save(PermissionGroup permissionGroup) {
		permissionGroupMapper.insert(permissionGroup);
	}

	@Override
	public PermissionGroup getPermissionGroupById(String permissionGroupId) {
		return permissionGroupMapper.selectByPrimaryKey(permissionGroupId);
	}

	@Override
	public void update(PermissionGroup permissionGroup) {
		permissionGroupMapper.updateByPrimaryKey(permissionGroup);
	}

	@Override
	public void deletePermissionGroup(String permissionGroupId) {
		permissionGroupMapper.deleteByPrimaryKey(permissionGroupId);
	}

	@Override
	public List<PermissionGroup> getAllPermissionGroups() {
		PermissionGroupExample example = new PermissionGroupExample();
		example.setOrderByClause("permission_group_id asc");
		return permissionGroupMapper.selectByExample(example);
	}

	@Override
	public void save(Permission permission) {
		permissionMapper.insert(permission);
	}

	@Override
	public Permission getPermissionById(String permissionId) {
		return permissionMapper.selectByPrimaryKey(permissionId);
	}

	@Override
	public Permission getPermissionByCode(String permissionCode) {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andPermissionCodeEqualTo(permissionCode);
		List<Permission> permissions = permissionMapper.selectByExample(example);
		return PublicUtil.isEmpty(permissions) ? null : permissions.get(0);
	}

	@Override
	public void update(Permission permission) {
		permissionMapper.updateByPrimaryKey(permission);
	}

	@Override
	public void deletePermission(String permissionId) {
		permissionMapper.deleteByPrimaryKey(permissionId);
	}

	@Override
	public List<Permission> getAllPermissions() {
		PermissionExample example = new PermissionExample();
		example.setOrderByClause("permission_name asc");
		return permissionMapper.selectByExample(example);
	}

}
