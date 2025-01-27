package com.ResumeAts.entity;

public class Resume {

    private String pdf;

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Resume() {
        super();
    }

    public Resume(String pdf) {
        super();
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Resume [pdf=" + pdf + "]";
    }
}
