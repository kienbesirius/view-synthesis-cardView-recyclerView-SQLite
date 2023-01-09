package com.fetchme.viewsynthesis;

public class Student {
    private String name;
    private String birth;
    private String university;
    private String sex; // 1 is male, 0 is female
    private String hobbies;
    private int IMG;

    public Student(String name, String birth, String university, String sex, String hobbies, int image) {
        this.name = name;
        this.birth = birth;
        this.university = university;
        this.sex = sex;
        this.hobbies = hobbies;
        IMG = image;
    }

    public Student(int IMG) {
        this.IMG = IMG;
    }

    public int getIMG() {
        return IMG;
    }

    public void setIMG(int IMG) {
        this.IMG = IMG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
