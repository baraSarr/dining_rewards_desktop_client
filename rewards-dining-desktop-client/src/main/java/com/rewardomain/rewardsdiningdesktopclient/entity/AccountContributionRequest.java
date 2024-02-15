package com.rewardomain.rewardsdiningdesktopclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountContributionRequest {
    private String name="";

    @JsonProperty("credit_card_number")
    private String ccnumber="";

    @JsonProperty("account_number")
    private String anumber="";

    @JsonProperty("allocation_percentage")
    private double percentage=0;

    public AccountContributionRequest() {
    }

    public AccountContributionRequest(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public AccountContributionRequest(String name, String ccnumber, String anumber) {
        this.name = name;
        this.ccnumber = ccnumber;
        this.anumber = anumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCcnumber() {
        return ccnumber;
    }

    public void setCcnumber(String ccnumber) {
        this.ccnumber = ccnumber;
    }

    public String getAnumber() {
        return anumber;
    }

    public void setAnumber(String anumber) {
        this.anumber = anumber;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}
