package com.mycampus.Server.Repository;

import com.mycampus.Server.Entity.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Fee extends JpaRepository<FeePayment,Long> {
}
