package com.dm.stu.domain;

public class PermissionGroup {
    private String permissionGroupId;

    private String permissionGroupName;

    public String getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(String permissionGroupId) {
        this.permissionGroupId = permissionGroupId == null ? null : permissionGroupId.trim();
    }

    public String getPermissionGroupName() {
        return permissionGroupName;
    }

    public void setPermissionGroupName(String permissionGroupName) {
        this.permissionGroupName = permissionGroupName == null ? null : permissionGroupName.trim();
    }
}