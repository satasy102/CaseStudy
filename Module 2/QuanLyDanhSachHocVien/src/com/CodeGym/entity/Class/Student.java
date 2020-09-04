package com.CodeGym.entity.Class;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    private int id;
    private String fullName;
    private String birthday;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private float fistScore;
    private float secondScore;
    private float thirdScore;
    private float fourthScore;
    private float average;


    public Student() {
    }

    public Student(int id, String fullName, String phoneNumber, String email,
                   String birthday, String gender, String address) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getFistScore() {
        return fistScore;
    }

    public void setFistScore(float fistScore) {
        this.fistScore = fistScore;
    }

    public float getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(float secondScore) {
        this.secondScore = secondScore;
    }

    public float getThirdScore() {
        return thirdScore;
    }

    public void setThirdScore(float thirdScore) {
        this.thirdScore = thirdScore;
    }

    public float getFourthScore() {
        return fourthScore;
    }

    public void setFourthScore(float fourthScore) {
        this.fourthScore = fourthScore;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }


    @Override
    public int compareTo(Student o) {
        return Float.compare( o.average,this.average);
    }
}

