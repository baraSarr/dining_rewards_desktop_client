package com.rewardomain.rewardsdiningdesktopclient.entity;

import java.time.LocalDateTime;

public class Reward {
    private long id;
    private long confirmationNumber;
    private double amount;
    private long merchantNumber;
    private LocalDateTime rewardDate;

    public Reward() {}

    public Reward(long id, long confirmationNumber, double amount, long merchantNumber, LocalDateTime rewardDate) {
        this.id = id;
        this.confirmationNumber = confirmationNumber;
        this.amount = amount;
        this.merchantNumber = merchantNumber;
        this.rewardDate = rewardDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(long confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(long merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public LocalDateTime getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(LocalDateTime rewardDate) {
        this.rewardDate = rewardDate;
    }

}
