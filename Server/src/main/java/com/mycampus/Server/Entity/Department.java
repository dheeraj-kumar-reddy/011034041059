package com.mycampus.Server.Entity;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deptId")
    private long deptId;

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                '}';
    }
}
