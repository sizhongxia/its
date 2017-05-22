package com.dm.stu.domain;

public class RolePermissionGroup {
    private String roleId;

    private String permissionGroupId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(String permissionGroupId) {
        this.permissionGroupId = permissionGroupId == null ? null : permissionGroupId.trim();
    }
}