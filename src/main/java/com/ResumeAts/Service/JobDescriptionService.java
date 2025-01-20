package com.ResumeAts.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ResumeAts.Repository.JobDescriptionRepository;
import com.ResumeAts.entity.JobDescription;

@Service
public class JobDescriptionService {

    @Autowired
    private JobDescriptionRepository jobDescriptionRepository;

    public JobDescription saveJobDescription(String description) {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setDescription(description);
        return jobDescriptionRepository.save(jobDescription);
    }
}

