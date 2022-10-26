package com.mycampus.Server.Repository;

import com.mycampus.Server.Entity.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student extends JpaRepository<StudentRegistration, String> {

}
