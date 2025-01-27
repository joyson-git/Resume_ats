package com.ResumeAts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import com.ResumeAts.Service.ResumeService;

import com.ResumeAts.entity.Resume;

import java.io.IOException;

import java.util.Map;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file) throws IllegalAccessException {
        try {
            Resume resume = resumeService.extractTextFromPdf(file);
            return ResponseEntity.ok(resume);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(Map.of("error", e.getMessage()));
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                                 .body(Map.of("error", e.getMessage()));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Failed to process resume: " + e.getMessage()));
        }
    }
 /*   private Resume extractTextFromPdf(MultipartFile file) throws IOException, IllegalAccessException {
        if (file.isEmpty()) {
            throw new IllegalAccessException("No file loaded");
        }

        System.out.println("Uploaded Content-Type: " + file.getContentType());

        if (!file.getContentType().equalsIgnoreCase("application/pdf")) {
            throw new IllegalArgumentException("Invalid file type. Only PDFs are allowed.");
        }

        String filename = file.getOriginalFilename();
        if (filename == null || !filename.toLowerCase().endsWith(".pdf")) {
            throw new IllegalArgumentException("Invalid file format. Please upload a valid PDF file.");
        }

        try (InputStream inputStream = file.getInputStream();
             PDDocument document = PDDocument.load(inputStream)) {

            if (document.isEncrypted()) {
                throw new SecurityException("Cannot process encrypted PDFs");
            }

            PDFTextStripper pdfStripper = new PDFTextStripper();
            String extractedText = pdfStripper.getText(document);

            Resume resume = new Resume();
            resume.setPdf(extractedText);

            return resume;
        } catch (IOException e) {
            throw new IOException("Error reading PDF file", e);
        }
    }

  */
}

