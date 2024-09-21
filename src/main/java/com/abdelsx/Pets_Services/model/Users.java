package com.abdelsx.Pets_Services.model;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column (nullable = false, unique = true)
    private String password;
    private int age;
    @Column (nullable = false, unique = true)
    private String email;

    public Users (String userName, String password, int age, String email){
        this.userName =  userName;
        this.password = password;
        this.age = age;
        this.email = email;
    }

    public Users (String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
