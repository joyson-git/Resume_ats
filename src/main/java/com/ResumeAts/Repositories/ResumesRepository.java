package com.ResumeAts.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ResumeAts.entity.resumes;


public interface ResumesRepository  extends  JpaRepository <resumes, Integer>{
	List<resumes> findByUploadedAtAfter(LocalDateTime dateTime);
		
}

