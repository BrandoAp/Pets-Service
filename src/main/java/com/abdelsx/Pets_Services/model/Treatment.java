package com.abdelsx.Pets_Services.model;

import jakarta.persistence.*;

@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column (nullable = false)
    private String NameTreatment;
    @Column (nullable = false)
    private float priceTreatment;

    public Treatment(){

    }

    public Treatment (String NameTreatment, float priceTreatment){
        this.NameTreatment = NameTreatment;
        this.priceTreatment = priceTreatment;
    }

    public float getPriceTreatment() {
        return priceTreatment;
    }

    public void setPriceTreatment(float priceTreatment) {
        this.priceTreatment = priceTreatment;
    }

    public String getNameTreatment() {
        return NameTreatment;
    }

    public void setNameTreatment(String nameTreatment) {
        NameTreatment = nameTreatment;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
