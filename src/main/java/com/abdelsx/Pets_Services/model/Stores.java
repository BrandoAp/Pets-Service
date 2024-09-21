package com.abdelsx.Pets_Services.model;

import jakarta.persistence.*;

@Entity
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (nullable = false)
    private String directionOfTheStore;
    @Column (nullable = false)
    private String nameOfTheStore;

    public Stores (String directionOfTheStore, String nameOfTheStore){
        this.directionOfTheStore = directionOfTheStore;
        this.nameOfTheStore = nameOfTheStore;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDirectionOfTheStore() {
        return directionOfTheStore;
    }

    public void setDirectionOfTheStore(String directionOfTheStore) {
        this.directionOfTheStore = directionOfTheStore;
    }

    public String getNameOfTheStore() {
        return nameOfTheStore;
    }

    public void setNameOfTheStore(String nameOfTheStore) {
        this.nameOfTheStore = nameOfTheStore;
    }
}
