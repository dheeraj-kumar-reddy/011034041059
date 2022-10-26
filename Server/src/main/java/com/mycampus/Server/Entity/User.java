package com.mycampus.Server.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="username")
    private Long username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private int role;

    @Column(name = "last_login_time")
    private long lastLoginTime;

    @Column(name = "account_status")
    private int accountStatus;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_no")
    private long mobileNo;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "admission_status")
    private int admissionStatus;

    @Column(name = "gender")
    private int gender;

    @Column(name = "dob")
    private Date dateOfBirth;

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(int admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", lastLoginTime=" + lastLoginTime +
                ", accountStatus=" + accountStatus +
                ", name='" + name + '\'' +
                ", mobileNo=" + mobileNo +
                ", emailId='" + emailId + '\'' +
                ", admissionStatus=" + admissionStatus +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
