package com.example.eatssu;

public class Dodam {
    private String 중식1;
    private String 중식4;
    private String 석식1;

    private Dodam() {
    }

    public Dodam(String 중식1, String 중식4, String 석식1) {
        this.중식1 = 중식1;
        this.중식4 = 중식4;
        this.석식1 = 석식1;
    }

    public String getJungsik1() {
        return 중식1;
    }

    public void setJungsik1(String 중식1) {
        this.중식1 = 중식1;
    }

    public String getJungsik4() {
        return 중식4;
    }

    public void setJungsik4(String 중식4) {
        this.중식4 = 중식4;
    }

    public String getSuksik1() {
        return 석식1;
    }

    public void setSuksik1(String 석식1) {
        this.석식1 = 석식1;
    }
}

