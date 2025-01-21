package com.ResumeAts.controller;



import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import com.ResumeAts.Service.ResumeService;
import com.ResumeAts.Service.ResumeComparisonService;
import com.ResumeAts.entity.Resume;

@RestController
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ResumeComparisonService resumeComparisonService;

    @PostMapping("/resumes/upload")
    public Resume uploadResume(@RequestParam("file") MultipartFile file) {
        try {
            return resumeService.extractTextFromPdf(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/compare")
    public Mono<Double> compareResumeWithJobDescription(@RequestBody Map<String, String> requestBody) {
        String resumeText = requestBody.get("resumeText");
        String jobDescriptionText = requestBody.get("jobDescriptionText");

        return resumeComparisonService.compareResumeWithJobDescription(resumeText, jobDescriptionText);
    }
}

