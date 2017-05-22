package com.dm.stu.domain;

public class Menu {
    private String menuId;

    private String menuPid;

    private String menuName;

    private Integer menuSerialNumber;

    private String menuIcon;

    private String menuPrefix;

    private String menuUiSref;

    private Boolean menuStatus;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid == null ? null : menuPid.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuSerialNumber() {
        return menuSerialNumber;
    }

    public void setMenuSerialNumber(Integer menuSerialNumber) {
        this.menuSerialNumber = menuSerialNumber;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getMenuPrefix() {
        return menuPrefix;
    }

    public void setMenuPrefix(String menuPrefix) {
        this.menuPrefix = menuPrefix == null ? null : menuPrefix.trim();
    }

    public String getMenuUiSref() {
        return menuUiSref;
    }

    public void setMenuUiSref(String menuUiSref) {
        this.menuUiSref = menuUiSref == null ? null : menuUiSref.trim();
    }

    public Boolean getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Boolean menuStatus) {
        this.menuStatus = menuStatus;
    }
}