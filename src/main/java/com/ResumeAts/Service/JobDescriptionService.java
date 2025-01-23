package com.ResumeAts.Service;


import org.springframework.stereotype.Service;
import com.ResumeAts.entity.JobDescription;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobDescriptionService {
    private final List<JobDescription> jobDescriptions = new ArrayList<>();

    public JobDescription saveJobDescription(String description) {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setDescription(description);
        jobDescriptions.add(jobDescription);
        return jobDescription;
    }
/*
    public List<JobDescription> getAllJobDescriptions() {
        return jobDescriptions;
    }
    */
}
