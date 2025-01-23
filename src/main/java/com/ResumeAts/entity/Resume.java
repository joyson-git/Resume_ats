package com.ResumeAts.entity;


public class Resume {
   

 
    @Override
	public String toString() {
		return "Resume [pdf=" + pdf + "]";
	}

	private String pdf;

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public Resume(String pdf) {
		super();
		this.pdf = pdf;
	}

	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	} 
    
}
