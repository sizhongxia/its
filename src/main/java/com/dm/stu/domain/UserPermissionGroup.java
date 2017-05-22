package com.dm.stu.domain;

public class UserPermissionGroup {
    private String userId;

    private String permissionGroupId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(String permissionGroupId) {
        this.permissionGroupId = permissionGroupId == null ? null : permissionGroupId.trim();
    }
}