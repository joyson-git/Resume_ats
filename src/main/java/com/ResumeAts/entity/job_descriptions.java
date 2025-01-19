package com.ResumeAts.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_descriptions")
public class job_descriptions {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int Id;
	
	@Column(name = "description", nullable = false)
	 private String  description;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
