package com.ResumeAts.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ResumeComparisonService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<Double> compareResumeWithJobDescription(String resumeText, String jobDescriptionText) {
        String apiUrl = "https://api.gemini.ai/compare"; // Replace with the actual Gemini AI API URL
        String apiKey = "YOUR_API_KEY"; // Replace with your actual API key

        return webClientBuilder.build()
                .post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(Map.of("resume", resumeText, "jobDescription", jobDescriptionText))
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Double) response.get("similarityScore"));
    }
}

