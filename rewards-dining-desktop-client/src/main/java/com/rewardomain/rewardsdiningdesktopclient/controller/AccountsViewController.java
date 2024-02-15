package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.HelloApplication;
import com.rewardomain.rewardsdiningdesktopclient.entity.Account;
import com.rewardomain.rewardsdiningdesktopclient.service.AccountContributionService;
import com.rewardomain.rewardsdiningdesktopclient.service.IAccountContributionService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.List;

public class AccountsViewController {

    IAccountContributionService accountContributionService;

    @FXML
    private FlowPane accountsPane;

    public AccountsViewController() {
        accountContributionService = new AccountContributionService();
    }

    @FXML
    private void initialize() {
        List<Account> accounts;
        try {
            accounts = accountContributionService.getAccounts();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (Account account : accounts) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Account.fxml"));
                accountsPane.getChildren().add(fxmlLoader.load());
                AccountController accountController = fxmlLoader.getController();
                accountController.setup(account);
            } catch (IOException e) {
                NotificationManager.showErrorNotification("Error", "Unable to load account card");
                e.printStackTrace();
            }

        }

    }

    public void addAccount() {
        WindowManager manager = WindowManager.getInstance();
        manager.showAccountForm(accountsPane);
    }
}
