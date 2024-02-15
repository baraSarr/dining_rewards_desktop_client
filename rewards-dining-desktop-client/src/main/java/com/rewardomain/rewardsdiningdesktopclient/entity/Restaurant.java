package com.rewardomain.rewardsdiningdesktopclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Restaurant {

    private long id;
    private long number;
    private String name;
    private double percentage;
    private String availability;
    private String executionChain;

    public Restaurant() {
    }

    public Restaurant(long number, String name, double percentage) {
        this.number = number;
        this.name = name;
        this.percentage = percentage;
        this.availability = "allowed";
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getNumber() {
        return number;
    }
    public void setNumber(long number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public String getAvailability() {
        return availability;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public String getExecutionChain() {
        return executionChain;
    }
    public void setExecutionChain(String executionChain) {
        this.executionChain = executionChain;
    }

}
