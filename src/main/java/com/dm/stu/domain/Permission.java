package com.dm.stu.domain;

public class Permission {
    private String permissionId;

    private String permissionName;

    private String permissionCode;

    private String permissionDescript;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissionDescript() {
        return permissionDescript;
    }

    public void setPermissionDescript(String permissionDescript) {
        this.permissionDescript = permissionDescript == null ? null : permissionDescript.trim();
    }
}