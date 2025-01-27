/*package com.ResumeAts.controller;

import com.ResumeAts.Service.ResumeComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/compare")
public class ResumeComparisonController {

    @Autowired
    private ResumeComparisonService resumeComparisonService;

    @PostMapping("/upload")
    public Mono<ResponseEntity<Map<String, Double>>> compareResumeWithJobDescription(
            @RequestParam("resumeFile") MultipartFile resumeFile,
            @RequestParam("jobDescriptionText") String jobDescriptionText) {

        if (resumeFile.isEmpty() || jobDescriptionText.trim().isEmpty()) {
            return Mono.just(ResponseEntity.badRequest()
                    .body(Map.of("error", -1.0))); // ✅ Fix: Use consistent Double type for error response
        }

        return resumeComparisonService.compareResumeWithJobDescription(resumeFile, jobDescriptionText);
    }
}*/
package com.ResumeAts.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ResumeAts.Service.ResumeComparisonService;
import com.ResumeAts.entity.JobDescription;
import com.ResumeAts.entity.Resume;

@RestController
@RequestMapping("/api/comparison")
public class  ResumeComparisonController  {

	@Autowired
    private ResumeComparisonService resumeComparisonService;

	 @PostMapping("/compare")
	    public ResponseEntity<?> compareResumeWithJobDescription(@RequestBody Map<String, String> requestBody) {
	        if (!requestBody.containsKey("resumeText") || !requestBody.containsKey("jobDescriptionText")) {
	            return ResponseEntity.badRequest()
	                                 .body(Map.of("error", "Missing required fields: resumeText and jobDescriptionText"));
	        }
	        
        String resumeText = requestBody.get("resumeText");
        String jobDescriptionText = requestBody.get("jobDescriptionText");

        Resume resume = new Resume(resumeText);
        JobDescription jobDescription = new JobDescription(jobDescriptionText);

        Map<String, String> comparisonResult = resumeComparisonService.compareResumeWithJobDescription(resume, jobDescription);
        return ResponseEntity.ok(comparisonResult);
    }
	 
	/*
	 @PostMapping("/compare")
	    public ResponseEntity<?> compareResumeWithJobDescription(@RequestBody Map<String, String> requestBody) {
	        // Assuming requestBody contains identifiers for the resume and job description
	        String resumeId = requestBody.get("resumeId");
	        String jobDescriptionId = requestBody.get("jobDescriptionId");

	        if (resumeId == null || jobDescriptionId == null) {
	            return ResponseEntity.badRequest()
	                                 .body(Map.of("error", "Missing required fields: resumeId and jobDescriptionId"));
	        }

	        // Retrieve the resume and job description using their IDs
	        Resume resume = resumeController.getResumeById(resumeId);
	        JobDescription jobDescription = jobDescriptionController.getJobDescriptionById(jobDescriptionId);

	        if (resume == null || jobDescription == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                 .body(Map.of("error", "Resume or Job Description not found"));
	        }

	        // Perform the comparison
	        Map<String, String> comparisonResult = resumeComparisonService.compareResumeWithJobDescription(resume, jobDescription);
	        return ResponseEntity.ok(comparisonResult);
	    } 
	
	
	*/
	
	}


