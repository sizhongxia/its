package com.dm.stu.service;

import java.util.List;

import com.dm.stu.domain.Menu;
import com.dm.stu.domain.Permission;
import com.dm.stu.domain.PermissionGroup;
import com.dm.stu.domain.Role;

/***
 * 系统权限相关服务接口
 * 
 * @author sizho
 *
 */
public interface TxJurisdictionService {
	/**
	 * 新增角色
	 * 
	 * @param role
	 */
	void save(Role role);

	/**
	 * 通过ID获取角色
	 * 
	 * @param roleId
	 * @return
	 */
	Role getRoleById(String roleId);

	/**
	 * 通过名称获取角色
	 * 
	 * @param roleId
	 * @return
	 */
	Role getRoleByName(String roleName);

	/**
	 * 更新角色
	 * 
	 * @param role
	 */
	void update(Role role);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 */
	void deleteRole(String roleId);

	/**
	 * 获取所有角色
	 */
	List<Role> getAllRoles();

	/**
	 * 保存菜单
	 * 
	 * @param menu
	 */
	void save(Menu menu);

	/**
	 * 通过ID获取菜单信息
	 * 
	 * @param menuId
	 * @return
	 */
	Menu getMenuById(String menuId);

	/**
	 * 更新菜单信息
	 * 
	 * @param menu
	 */
	void update(Menu menu);

	/**
	 * 删除菜单信息
	 * 
	 * @param menuId
	 */
	void deleteMenu(String menuId);

	/**
	 * 获取所有菜单信息
	 */
	List<Menu> getAllMenus();

	/**
	 * 通过父级ID获取所有子集菜单信息
	 * 
	 * @param menuId
	 * @return
	 */
	List<Menu> getMenuByParentId(String menuPid);

	/**
	 * 获取所有父级菜单信息
	 */
	List<Menu> getParentMenus();

	/**
	 * 保存权限组
	 * 
	 * @param permissionGroup
	 */
	void save(PermissionGroup permissionGroup);

	/**
	 * 通过ID获取权限组
	 * 
	 * @param permissionGroupId
	 * @return
	 */
	PermissionGroup getPermissionGroupById(String permissionGroupId);

	/**
	 * 更新权限组
	 * 
	 * @param permission
	 */
	void update(PermissionGroup permission);

	/**
	 * 删除权限组
	 * 
	 * @param permissionGroupId
	 */
	void deletePermissionGroup(String permissionGroupId);

	/**
	 * 获取所有权限组
	 * 
	 * @return
	 */
	List<PermissionGroup> getAllPermissionGroups();

	/**
	 * 保存权限字
	 * 
	 * @param permission
	 */
	void save(Permission permission);

	/**
	 * 通过ID获取权限字
	 * 
	 * @param permissionId
	 * @return
	 */
	Permission getPermissionById(String permissionId);

	/**
	 * 通过CODE获取权限字
	 * 
	 * @param permissionCode
	 * @return
	 */
	Permission getPermissionByCode(String permissionCode);

	/**
	 * 更新权限字
	 * 
	 * @param permission
	 */
	void update(Permission permission);

	/**
	 * 删除权限字
	 * 
	 * @param permissionId
	 */
	void deletePermission(String permissionId);

	/**
	 * 获取所有权限字
	 * 
	 * @return
	 */
	List<Permission> getAllPermissions();

}
