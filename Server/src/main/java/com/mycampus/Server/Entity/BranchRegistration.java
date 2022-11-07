package com.mycampus.Server.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Branch")
public class BranchRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Branch_Id")
    private long branchId;

    @Column(name = "Dept_Id")
    private long deptId;

    @Column(name = "Branch_Name")
    private String branchName;

    @Column(name = "Branch_Code")
    private String branchCode;

    @Column(name = "Hod_Username")
    private long hodUsername;

    @Column(name = "Total_Seats_available")
    private int totalSeatsAvailable;

    @Column(name = "Seats_Booked")
    private int seatsBooked;

    @Column(name = "Fee_For_CET")
    private long feeForCet;

    @Column(name = "Fee_For_Comedk")
    private long feeForComedk;

    @Column(name = "Fee_For_UQ")
    private long feeForUQ;

    @Column(name = "No_of_years")
    private long noOfYears;

    public long getFeeForCet() {
        return feeForCet;
    }

    public void setFeeForCet(long feeForCet) {
        this.feeForCet = feeForCet;
    }

    public long getFeeForComedk() {
        return feeForComedk;
    }

    public void setFeeForComedk(long feeForComedk) {
        this.feeForComedk = feeForComedk;
    }

    public long getFeeForUQ() {
        return feeForUQ;
    }

    public void setFeeForUQ(long feeForUQ) {
        this.feeForUQ = feeForUQ;
    }

    public long getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(long noOfYears) {
        this.noOfYears = noOfYears;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public long getHodUsername() {
        return hodUsername;
    }

    public void setHodUsername(long hodUsername) {
        this.hodUsername = hodUsername;
    }

    public int getTotalSeatsAvailable() {
        return totalSeatsAvailable;
    }

    public void setTotalSeatsAvailable(int totalSeatsAvailable) {
        this.totalSeatsAvailable = totalSeatsAvailable;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "BranchRegistration{" +
                "branchId=" + branchId +
                ", deptId=" + deptId +
                ", branchName='" + branchName + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", hodUsername=" + hodUsername +
                ", totalSeatsAvailable=" + totalSeatsAvailable +
                ", seatsBooked=" + seatsBooked +
                ", feeForCet=" + feeForCet +
                ", feeForComedk=" + feeForComedk +
                ", feeForUQ=" + feeForUQ +
                ", noOfYears=" + noOfYears +
                '}';
    }
}
