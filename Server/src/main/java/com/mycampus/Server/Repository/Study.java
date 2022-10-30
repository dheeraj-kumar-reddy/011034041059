package com.mycampus.Server.Repository;

import com.mycampus.Server.Entity.StudyMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Study extends JpaRepository<StudyMaterial, String> {
}
