package com.example.eatssu;

public class Menu {
    private String 기숙사식당_0;
    private String 기숙사식당_1;
    private String 기숙사식당_2;
    private String 도담_석식1;
    private String 도담_중식1;
    private String 도담_중식4;
    private String 학생식당_1_0;
    private String 학생식당_1_1;

    private Menu(){}

    public Menu(String 기숙사식당_0, String 기숙사식당_1, String 기숙사식당_2, String 도담_석식1, String 도담_중식1, String 도담_중식4, String 학생식당_1_0, String 학생식당_1_1) {
        this.기숙사식당_0 = 기숙사식당_0;
        this.기숙사식당_1 = 기숙사식당_1;
        this.기숙사식당_2 = 기숙사식당_2;
        this.도담_석식1 = 도담_석식1;
        this.도담_중식1 = 도담_중식1;
        this.도담_중식4 = 도담_중식4;
        this.학생식당_1_0 = 학생식당_1_0;
        this.학생식당_1_1 = 학생식당_1_1;
    }
    public String getGisik0() {
        return 기숙사식당_0;
    }
    public void setGisik0(String 기숙사식당_0) {
        this.기숙사식당_0 = 기숙사식당_0;
    }
    public String getGisik1() {
        return 기숙사식당_1;
    }
    public void setGisik1(String 기숙사식당_1) {
        this.기숙사식당_1 = 기숙사식당_1;
    }
    public String getGisik2() {
        return 기숙사식당_2;
    }
    public void setGisik2(String 기숙사식당_2) {
        this.기숙사식당_2 = 기숙사식당_2;
    }
    public String getDodam0() {
        return 도담_석식1;
    }
    public void setDodam0(String 도담_석식1) {
        this.도담_석식1 = 도담_석식1;
    }
    public String getDodam1() {
        return 도담_중식1;
    }
    public void setDodam1(String 도담_중식1) {
        this.도담_중식1 = 도담_중식1;
    }
    public String getDodam2() {
        return 도담_중식4;
    }
    public void setDodam2(String 도담_중식4) {
        this.도담_중식4 = 도담_중식4;
    }
    public String getHaksik0() {
        return 학생식당_1_0;
    }
    public void setHaksik0(String 학생식당_1_0) {
        this.학생식당_1_0 = 학생식당_1_0;
    }
    public String getHaksik1() {
        return 학생식당_1_1;
    }
    public void setHaksik1(String 학생식당_1_1) {
        this.학생식당_1_1 = 학생식당_1_1;
    }

}
