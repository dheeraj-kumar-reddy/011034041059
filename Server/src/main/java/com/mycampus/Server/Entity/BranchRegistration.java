package com.mycampus.Server.Entity;

import javax.persistence.*;

@Entity
public class BranchRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "branchId")
    private long branchId;

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "BranchRegistration{" +
                "branchId=" + branchId +
                '}';
    }
}
