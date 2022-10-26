package com.mycampus.Server.Repository;

import com.mycampus.Server.Entity.FacultyRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Faculty extends JpaRepository<FacultyRegistration,String> {
}
