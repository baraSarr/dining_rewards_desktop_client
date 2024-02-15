package com.rewardomain.rewardsdiningdesktopclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    private Long id;


    private String owner;

    @JsonProperty("account_number")
    private String number;

    private double benefits;

    @JsonIgnore
    private List<Beneficiary> beneficiaries = new ArrayList<>();

    @JsonIgnore
    private CreditCard creditCard;


    public Account() {}



    public Account(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    //Getters end setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public double getBenefits() {
        return benefits;
    }

    public void setBenefits(double benefits) {
        this.benefits = benefits;
    }

    public boolean isValid() {
        double totalPercentage = 0.0;
        for (Beneficiary beneficiary : beneficiaries) {
            totalPercentage += beneficiary.getPercentage();
        }
        return totalPercentage == 100;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
