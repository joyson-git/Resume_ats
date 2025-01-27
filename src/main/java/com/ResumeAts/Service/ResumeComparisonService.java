package com.ResumeAts.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ResumeAts.entity.JobDescription;
import com.ResumeAts.entity.Resume;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResumeComparisonService {

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public Map<String, String> compareResumeWithJobDescription(Resume resume, JobDescription jobDescription) {
        // Prepare the request payload for Gemini AI
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("resume", resume.getPdf());
        requestPayload.put("jobDescription", jobDescription.getDescription());

        // Create headers for the API request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + geminiApiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HTTP entity with the request payload and headers
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestPayload, headers);

        // Make the API call to Gemini AI
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map<String, String>> response = restTemplate.exchange(
                geminiApiUrl,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<Map<String, String>>() {}
        );

        // Return the comparison results
        return response.getBody();
    }
}
