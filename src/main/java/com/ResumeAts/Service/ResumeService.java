package com.ResumeAts.Service;
/*


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ResumeAts.entity.Resume;

@Service
public class ResumeService {

    public Resume extractTextFromPdf(MultipartFile file) throws IOException {
        // Convert MultipartFile to File
        File tempFile = File.createTempFile("temp", ".pdf");
        
        try (InputStream inputStream = file.getInputStream();
        		
             FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
        try (PDDocument document = PDDocument.load(tempFile)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            Resume resume = new Resume();
            resume.setText(pdfStripper.getText(document));
            return resume;
        } finally {
            tempFile.delete(); // Ensure deletion after use
        }
        
	
	
	 public String extractTextFromPdf(MultipartFile file) throws IOException {
	        try (InputStream inputStream = file.getInputStream();
	             PDDocument document = PDDocument.load(inputStream)) {

	            PDFTextStripper pdfStripper = new PDFTextStripper();
	            return pdfStripper.getText(document);
	        }
    }
	 
	 
}
*/

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ResumeAts.entity.Resume;

@Service
public class ResumeService {
    
    public Resume extractTextFromPdf(MultipartFile file) throws IOException, IllegalAccessException {
    	
    	if(file.isEmpty()) {
    		throw new IllegalAccessException("no load file");
    	}
    	
    	   System.out.println("Uploaded Content-Type: " + file.getContentType());

    	
    	   if (!file.getContentType().equalsIgnoreCase("application/pdf")) {
    		    throw new IllegalArgumentException("Invalid file type. Only PDFs are allowed.");
    		}


    	 // Validate file extension as an extra precaution
    	   String filename = file.getOriginalFilename();
    	   if (filename == null || !filename.toLowerCase().endsWith(".pdf")) {
    	       throw new IllegalArgumentException("Invalid file format. Please upload a valid PDF file.");
    	   }

    	
        try (InputStream inputStream = file.getInputStream();
             PDDocument document = PDDocument.load(inputStream)) {

        	
        	if(document.isEncrypted()) {
        		 throw new SecurityException("Cannot process encrypted PDFs");
        	}
        	
        	
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String extractedText = pdfStripper.getText(document);
            
            
            Resume resume = new Resume();
            resume.setPdf(extractedText);
            
            return resume;
        }catch (IOException e) {
			throw new IOException("Error reading PDF file", e);
		}
        }
    }

