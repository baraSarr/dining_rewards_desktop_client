package com.rewardomain.rewardsdiningdesktopclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Beneficiary {
    private Long id;


    private double percentage;

    private String name;

    private double savings;

    @JsonIgnore
    private Account account;

    public Beneficiary() {}

    public Beneficiary(double percentage, String name) {
        this.percentage = percentage;
        this.name = name;
        this.savings = 0;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
