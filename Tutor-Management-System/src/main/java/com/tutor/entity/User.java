package com.tutor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 60, message = "name should be greater than 3 and less then 60 characters")
    private String name;

    public User() {
    }

    public User(Long id, String name, String email, String password, String mobile, String address, boolean emailVerified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.emailVerified = emailVerified;
    }

    @Column(name = "email", nullable = false)
    @Email(message = "email should have @, . character and number only")
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 6, max = 12, message = "password should be from 6 to 12 characters and should have number, character and special character also")
    private String password;

    @Size(min = 10, max = 10, message = "mobile number should be only of 10 digits")
    private String mobile;

    @Size(min = 5, max = 40, message = "address should be between 5 to 40 character only")
    private String address;

    private boolean emailVerified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }
}
