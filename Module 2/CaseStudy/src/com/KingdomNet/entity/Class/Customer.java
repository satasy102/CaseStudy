package com.KingdomNet.entity.Class;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String fullname;
    private int age;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private int cyberID;

    public Customer(int id, String fullname, String phone, String email, int age, String gender, String address, int cyberID) {
        this.id = id;
        this.fullname = fullname;
        this.phoneNumber=phone;
        this.age = age;
        this.email=email;
        this.gender=gender;
        this.address = address;
        this.cyberID = cyberID;
    }

    public Customer(int id, String fullname, int age, String address) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.address = address;
    }

    public Customer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getCyberID() {
        return cyberID;
    }

}
