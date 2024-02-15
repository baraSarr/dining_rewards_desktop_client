package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.HelloApplication;
import com.rewardomain.rewardsdiningdesktopclient.entity.Account;
import com.rewardomain.rewardsdiningdesktopclient.entity.AccountContributionRequest;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.service.AccountContributionService;
import com.rewardomain.rewardsdiningdesktopclient.service.IAccountContributionService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class AccountFormController {

    private FlowPane pane;
    private IAccountContributionService accountContributionService;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField accountNumberTF;
    @FXML
    private TextField ccNummberTF;

    public AccountFormController() {
        accountContributionService = new AccountContributionService();
    }

    public FlowPane getPane() {
        return pane;
    }

    public void setPane(FlowPane pane) {
        this.pane = pane;
    }

    public void registerAccount() {
        String name = nameTF.getText();
        String accountNumber = accountNumberTF.getText();
        String creditCardNumber = ccNummberTF.getText();
        AccountContributionRequest request = new AccountContributionRequest(name, creditCardNumber, accountNumber);
        try {
            DefaultResponse response = accountContributionService.createAccount(request);
            if(response.getCode() == 201) {
                NotificationManager.showInfoNotification("Registration", "New account added !");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Account.fxml"));
                pane.getChildren().add(fxmlLoader.load());
                AccountController accountController = fxmlLoader.getController();
                accountController.setup(new Account(name, accountNumber));
            }
            else {
                NotificationManager.showErrorNotification("Registration", "Account registration failed !");
            }
        } catch (JsonProcessingException e) {
            NotificationManager.showErrorNotification("Error", "Unable to send request");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
