package com.ResumeAts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResumeAts.entity.JobDescription;

@Repository
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {
}
