package com.ResumeAts.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ResumeAts.Service.ResumeComparisonService;

import java.util.Map;

@RestController
@RequestMapping("/api/compare")
public class ResumeComparisonController {

    @Autowired
    private ResumeComparisonService resumeComparisonService;

    @PostMapping
    public ResponseEntity<?> compareResumeWithJobDescription(@RequestBody Map<String, String> requestBody) {
        if (!requestBody.containsKey("resumeText") || !requestBody.containsKey("jobDescriptionText")) {
            return ResponseEntity.badRequest()
                                 .body(Map.of("error", "Missing required fields: resumeText, jobDescriptionText"));
        }

        String resumeText = requestBody.get("resumeText");
        String jobDescriptionText = requestBody.get("jobDescriptionText");

        try {
            Double similarityScore = resumeComparisonService.compareResumeWithJobDescription(resumeText, jobDescriptionText).block();
            return ResponseEntity.ok(Map.of("similarityScore", similarityScore));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Failed to compare resume with job description: " + e.getMessage()));
        }
    }
}

