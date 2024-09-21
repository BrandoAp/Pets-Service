package com.abdelsx.Pets_Services.model;

import jakarta.persistence.*;

@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column (nullable = false, unique = true)
    private String CIP;
    @Column (nullable = false)
    private String position;

    public Personal (String firstName, String lastName, String CIP, String position){
        this.firstName = firstName;
        this.lastName = lastName;
        this.CIP = CIP;
        this.position = position;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCIP() {
        return CIP;
    }

    public void setCIP(String CIP) {
        this.CIP = CIP;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
