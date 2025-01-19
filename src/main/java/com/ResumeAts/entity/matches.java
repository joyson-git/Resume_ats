package com.ResumeAts.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matches")
public class matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @Column(name = "resume_id")
    private Long resumeId;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "match_score")
    private Float matchScore;

    @Column(name = "matched_at")
    private LocalDateTime matchedAt;

    @ElementCollection
    @Column(name = "keywords")
    private List<String> keywords;

    @ElementCollection
    @Column(name = "skills")
    private List<String> skills;

    @ElementCollection
    @Column(name = "experiences")
    private List<String> experiences;

    @ElementCollection
    @Column(name = "education")
    private List<String> education;

    @ElementCollection
    @Column(name = "achievements")
    private List<String> achievements;

    @ElementCollection
    @Column(name = "required_skills")
    private List<String> requiredSkills;

    @ElementCollection
    @Column(name = "responsibilities")
    private List<String> responsibilities;

    @ElementCollection
    @Column(name = "preferred_qualifications")
    private List<String> preferredQualifications;

    // Getters and setters

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Float getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Float matchScore) {
        this.matchScore = matchScore;
    }

    public LocalDateTime getMatchedAt() {
        return matchedAt;
    }

    public void setMatchedAt(LocalDateTime matchedAt) {
        this.matchedAt = matchedAt;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<String> experiences) {
        this.experiences = experiences;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    public List<String> getPreferredQualifications() {
        return preferredQualifications;
    }

    public void setPreferredQualifications(List<String> preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }
}
