package com.mycampus.Server.Repository;

import com.mycampus.Server.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByMobileNo(long mobileNo);

    User findByEmailId(String mailId);

    boolean existsByUsernameAndAdmissionStatus(long username, int admissionStatus);
}
