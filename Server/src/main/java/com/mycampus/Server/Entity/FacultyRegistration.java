package com.mycampus.Server.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacultyRegistration {
    @Id
    @Column(name = "EmpId")
    private String empId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "FacultyRegistration{" +
                "empId='" + empId + '\'' +
                '}';
    }
}
