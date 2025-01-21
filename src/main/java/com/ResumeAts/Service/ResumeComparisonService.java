package com.ResumeAts.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ResumeComparisonService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public Mono<Double> compareResumeWithJobDescription(String resumeText, String jobDescriptionText) {
        return webClientBuilder.build()
                .post()
                .uri(geminiApiUrl)
                .header("Authorization", "Bearer " + geminiApiKey)
                .bodyValue(Map.of("resume", resumeText, "jobDescription", jobDescriptionText))
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Double) response.get("similarityScore"));
    }
}
