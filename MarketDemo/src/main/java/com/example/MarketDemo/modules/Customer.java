package com.example.MarketDemo.modules;

import jakarta.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;

    private Integer Password;
    private String Fname;
    private String Lname;
    private String email;
    private Integer age;
    public Customer() {
    }


    public Customer(Long id, Integer password, String fname, String lname, String email, Integer age) {
        this.id = id;
        this.Password = password;
        this.Fname = fname;
        this.Lname = lname;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer password) {
        this.Password = password;
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


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Fname='" + Fname + '\'' +
                ", Lname='" + Lname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age + '}';
    }
}
