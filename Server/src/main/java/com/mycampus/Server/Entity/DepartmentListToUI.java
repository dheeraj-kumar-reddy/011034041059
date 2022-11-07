package com.mycampus.Server.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentListToUI {
    private long deptId;

    private String deptName;

    private String deptCode;

    private String directorName;

    private String asstDirectorName;

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getAsstDirectorName() {
        return asstDirectorName;
    }

    public void setAsstDirectorName(String asstDirectorName) {
        this.asstDirectorName = asstDirectorName;
    }

    @Override
    public String toString() {
        return "DepartmentListToUI{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", directorName='" + directorName + '\'' +
                ", asstDirectorName='" + asstDirectorName + '\'' +
                '}';
    }
}
