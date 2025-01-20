package com.ResumeAts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResumeAts.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
	
}
