package com.mycampus.Server.Repository;

import com.mycampus.Server.Entity.BranchRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Branch extends JpaRepository<BranchRegistration,Long> {
    boolean existsByBranchCode(String branchCode);

    boolean existsByBranchName(String branchName);
}
