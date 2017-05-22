package com.dm.stu.domain;

public class PGroupPermission {
    private String permissionGroupId;

    private String permissionId;

    public String getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(String permissionGroupId) {
        this.permissionGroupId = permissionGroupId == null ? null : permissionGroupId.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }
}