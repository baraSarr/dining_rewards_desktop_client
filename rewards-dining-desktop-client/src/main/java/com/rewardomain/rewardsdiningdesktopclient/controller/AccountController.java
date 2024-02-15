package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.Account;
import com.rewardomain.rewardsdiningdesktopclient.entity.Beneficiary;
import com.rewardomain.rewardsdiningdesktopclient.service.AccountContributionService;
import com.rewardomain.rewardsdiningdesktopclient.service.IAccountContributionService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class AccountController {
    private Account account;

    private IAccountContributionService accountContributionService;
    @FXML
    private Label accountNumberLabel;
    @FXML
    private Label ownerLabel;
    @FXML
    private Label validityLabel;
    @FXML
    private Label benefitsLabel;

    @FXML
    private Button beneficiariesButton;

    public AccountController() {
        accountContributionService = new AccountContributionService();
    }

    public void setup(Account account) {
        this.account = account;
        accountNumberLabel.setText(account.getNumber());
        ownerLabel.setText(account.getOwner());
        try {
            List<Beneficiary> beneficiaries = accountContributionService.getBeneficiaries(account.getNumber());
            account.setBeneficiaries(beneficiaries);
            if(account.isValid()) validityLabel.setText("True");
            else validityLabel.setText("false");
        } catch (JsonProcessingException e) {
            NotificationManager.showErrorNotification("Error", "Unable to fetch beneficiaries");
            e.printStackTrace();
        }
        benefitsLabel.setText(String.valueOf(account.getBenefits()));
    }

    @FXML
    private void initialize() {

    }

    public void viewBeneficiaries() {
        WindowManager manager = WindowManager.getInstance();
        manager.showBeneficiariesView(account.getNumber());
    }
}
