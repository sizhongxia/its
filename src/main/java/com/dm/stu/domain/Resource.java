package com.dm.stu.domain;

import java.util.Date;

public class Resource {
    private String resId;

    private String resFilename;

    private Long resSize;

    private String resPath;

    private Date resUploadTime;

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getResFilename() {
        return resFilename;
    }

    public void setResFilename(String resFilename) {
        this.resFilename = resFilename == null ? null : resFilename.trim();
    }

    public Long getResSize() {
        return resSize;
    }

    public void setResSize(Long resSize) {
        this.resSize = resSize;
    }

    public String getResPath() {
        return resPath;
    }

    public void setResPath(String resPath) {
        this.resPath = resPath == null ? null : resPath.trim();
    }

    public Date getResUploadTime() {
        return resUploadTime;
    }

    public void setResUploadTime(Date resUploadTime) {
        this.resUploadTime = resUploadTime;
    }
}