package com.mycampus.Server.Entity;

import javax.persistence.Column;

public class BranchToUI {
    private long branchId;

    private long deptId;

    private String branchName;

    private String branchCode;

    private String  hodName;

    private int totalSeatsAvailable;

    private int seatsBooked;

    private long feeForCet;

    private long feeForComedk;

    private long feeForUQ;

    private int noOfYears;

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

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
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

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    @Override
    public String toString() {
        return "BranchToUI{" +
                "branchId=" + branchId +
                ", deptId=" + deptId +
                ", branchName='" + branchName + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", hodName='" + hodName + '\'' +
                ", totalSeatsAvailable=" + totalSeatsAvailable +
                ", seatsBooked=" + seatsBooked +
                ", feeForCet=" + feeForCet +
                ", feeForComedk=" + feeForComedk +
                ", feeForUQ=" + feeForUQ +
                ", noOfYears=" + noOfYears +
                '}';
    }
}
