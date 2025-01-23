package com.ResumeAts.Service;



import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
                .onStatus(status -> status.isError(), clientResponse -> {
                    return clientResponse.bodyToMono(String.class)
                            .flatMap(errorMessage -> Mono.error(new RuntimeException("API error: " + errorMessage)));
                })
                .bodyToMono(Map.class)
                .map(response -> {
                    if (response.containsKey("similarityScore")) {
                        Double similarityScore = (Double) response.get("similarityScore");
                        return similarityScore * 100; // Convert to percentage
                    } else {
                        throw new RuntimeException("similarityScore not found in the response");
                    }
                })
                .doOnError(error -> {
                    // Log the error for debugging purposes
                    System.err.println("Error occurred: " + error.getMessage());
                });
    }
}
