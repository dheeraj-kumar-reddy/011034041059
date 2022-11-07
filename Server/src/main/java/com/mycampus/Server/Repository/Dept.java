package com.mycampus.Server.Repository;

import com.mycampus.Server.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dept extends JpaRepository<Department, Long> {
    boolean existsByDeptName(String deptName);

    boolean existsByDeptCode(String deptCode);
}
