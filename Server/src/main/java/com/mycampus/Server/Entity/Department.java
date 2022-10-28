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

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", directorUsername=" + directorUsername +
                ", assDirectorUsername=" + assDirectorUsername +
                '}';
    }
}
