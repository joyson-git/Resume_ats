package com.ResumeAts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResumeAts.entity.job_descriptions;


@Repository
public interface JobDescriptionsRepository extends JpaRepository< job_descriptions ,Integer>{

}
