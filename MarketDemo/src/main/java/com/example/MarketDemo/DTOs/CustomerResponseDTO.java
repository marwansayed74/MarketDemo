package com.example.MarketDemo.DTOs;

public class CustomerResponseDTO {
    private String Fname;
    private String Lname;
    private String email;
    private Integer age;

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
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

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(String fname, String lname, String email, Integer age) {
        Fname = fname;
        Lname = lname;
        this.email = email;
        this.age = age;
    }


}
