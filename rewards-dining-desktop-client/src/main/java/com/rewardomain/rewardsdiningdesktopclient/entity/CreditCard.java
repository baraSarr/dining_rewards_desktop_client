package com.rewardomain.rewardsdiningdesktopclient.entity;

public class CreditCard {
    private Long id;

    private String number;

    private Account account;

    public CreditCard() {}

    public CreditCard(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
