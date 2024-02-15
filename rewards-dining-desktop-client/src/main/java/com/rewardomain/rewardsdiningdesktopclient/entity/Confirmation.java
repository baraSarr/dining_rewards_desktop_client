package com.rewardomain.rewardsdiningdesktopclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Confirmation {
    @JsonProperty("reward_confirmation_number")
    private long rewardConfirmation;

    private String executionChain;

    public Confirmation() {}

    public Confirmation(long rewardConfirmation, String chain) {
        super();
        this.rewardConfirmation = rewardConfirmation;
        setExecutionChain(chain);
    }

    public long getRewardConfirmation() {
        return rewardConfirmation;
    }

    public void setRewardConfirmation(long rewardConfirmation) {
        this.rewardConfirmation = rewardConfirmation;
    }

    public String getExecutionChain() {
        return executionChain;
    }

    public void setExecutionChain(String executionChain) {
        this.executionChain = executionChain;
    }




}
