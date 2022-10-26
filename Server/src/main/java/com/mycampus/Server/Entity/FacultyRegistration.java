package com.mycampus.Server.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacultyRegistration {
    @Id
    @Column(name = "EmpId")
    private String empId;

    @Column(name = "Qualification_1")
    private String qualification1;

    @Column(name = "Qualification_2")
    private String qualification2;

    @Column(name = "Qualification_3")
    private String qualification3;

    @Column(name = "Address")
    private String address;

    @Column(name = "Years_of_experience")
    private int yearsOfExperience;

    @Column(name = "username")
    private long username;

    @Column(name = "Dept_Id")
    private long deptId;

    @Column(name = "Brnach_Id")
    private long branch_Id;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getQualification1() {
        return qualification1;
    }

    public void setQualification1(String qualification1) {
        this.qualification1 = qualification1;
    }

    public String getQualification2() {
        return qualification2;
    }

    public void setQualification2(String qualification2) {
        this.qualification2 = qualification2;
    }

    public String getQualification3() {
        return qualification3;
    }

    public void setQualification3(String qualification3) {
        this.qualification3 = qualification3;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public long getBranch_Id() {
        return branch_Id;
    }

    public void setBranch_Id(long branch_Id) {
        this.branch_Id = branch_Id;
    }

    @Override
    public String toString() {
        return "FacultyRegistration{" +
                "empId='" + empId + '\'' +
                ", qualification1='" + qualification1 + '\'' +
                ", qualification2='" + qualification2 + '\'' +
                ", qualification3='" + qualification3 + '\'' +
                ", address='" + address + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", username=" + username +
                ", deptId=" + deptId +
                ", branch_Id=" + branch_Id +
                '}';
    }
}
