package com.mycampus.Server.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Dept_Id")
    private long deptId;

    @Column(name = "Dept_Name")
    private String deptName;

    @Column(name = "Dept_Code")
    private String deptCode;

    @Column(name = "Director_Username")
    private long directorUsername;

    @Column(name = "Ass_Director_Username")
    private long assDirectorUsername;

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

    public long getDirectorUsername() {
        return directorUsername;
    }

    public void setDirectorUsername(long directorUsername) {
        this.directorUsername = directorUsername;
    }

    public long getAssDirectorUsername() {
        return assDirectorUsername;
    }

    public void setAssDirectorUsername(long assDirectorUsername) {
        this.assDirectorUsername = assDirectorUsername;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", directorUsername=" + directorUsername +
                ", assDirectorUsername=" + assDirectorUsername +
                '}';
    }
}
