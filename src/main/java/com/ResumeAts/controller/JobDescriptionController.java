package com.ResumeAts.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ResumeAts.Service.JobDescriptionService;
import com.ResumeAts.entity.JobDescription;

import java.util.Map;

@RestController
@RequestMapping("/api/job-descriptions")
public class JobDescriptionController {

    @Autowired
    private JobDescriptionService jobDescriptionService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadJobDescription(@RequestBody Map<String, String> requestBody) {
        if (!requestBody.containsKey("description")) {
            return ResponseEntity.badRequest()
                                 .body(Map.of("error", "Missing required field: description"));
        }

        String description = requestBody.get("description");
        JobDescription jobDescription = jobDescriptionService.saveJobDescription(description);
        return ResponseEntity.ok(jobDescription);
    }
}

