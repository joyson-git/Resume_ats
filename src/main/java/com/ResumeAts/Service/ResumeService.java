package com.ResumeAts.Service;



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

        // Load PDF document from File
        PDDocument document = PDDocument.load(tempFile);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();

        // Delete the temporary file
        tempFile.delete();

        Resume resume = new Resume();
        resume.setText(text);
        return resume;
    }
}
