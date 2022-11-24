package com.example.MarketDemo.DTOs;

public class CustomerRequestDTO {
    private String Fname;
    private String Lname;
    private String email;
    private Integer age;

    private Integer Password;

    public CustomerRequestDTO() {
    }

    public CustomerRequestDTO(String fname, String lname, String email, Integer age, Integer password) {
        Fname = fname;
        Lname = lname;
        this.email = email;
        this.age = age;
        Password = password;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        this.Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        this.Lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer password) {
        Password = password;
    }
}
