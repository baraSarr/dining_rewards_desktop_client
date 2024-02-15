package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.AccountContributionRequest;
import com.rewardomain.rewardsdiningdesktopclient.entity.Beneficiary;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.service.AccountContributionService;
import com.rewardomain.rewardsdiningdesktopclient.service.IAccountContributionService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BeneficiaryFormController {
    private TableView<Beneficiary> table;
    @FXML
    private Label title;

    private final String CREATE_STRING = "Beneficiary Registration";
    private final String UPDATE_STRING = "Beneficiary Registration";

    private IAccountContributionService service;
    private String accountNumber;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField percentageTF;

    public BeneficiaryFormController() {
        service = new AccountContributionService();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTable(TableView<Beneficiary> table) {
        this.table = table;
    }

    public void addBeneficiary() {
        String name = nameTF.getText();
        double percentage = Double.parseDouble(percentageTF.getText());
        AccountContributionRequest request = new AccountContributionRequest(name, percentage);
        try {
            DefaultResponse response = service.createBeneficiary(accountNumber, request);
            if(response.getCode() == 201) {
                NotificationManager.showInfoNotification("Registration", "New beneficiary added !");
                table.getItems().add(new Beneficiary(percentage, name));
                table.refresh();
            }
            else {
                NotificationManager.showErrorNotification("Registration", "Beneficiary registration failed !");
            }
        } catch (JsonProcessingException e) {
            NotificationManager.showErrorNotification("Error", "Unable to send request");
        }

    }

}
