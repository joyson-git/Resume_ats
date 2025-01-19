package com.ResumeAts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resumes")
public class resumes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	
	
	 @Column(name = "uploaded_at", nullable = false)
	 private LocalDateTime uploadedAt;


	public resumes(int id, LocalDateTime uploadedAt) {
		super();
		this.id = id;
		this.uploadedAt = uploadedAt;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}


	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}
	
	

	

}
