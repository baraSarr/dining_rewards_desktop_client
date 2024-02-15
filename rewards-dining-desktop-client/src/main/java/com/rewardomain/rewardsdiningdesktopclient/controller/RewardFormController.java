package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.Confirmation;
import com.rewardomain.rewardsdiningdesktopclient.entity.Dining;
import com.rewardomain.rewardsdiningdesktopclient.service.IRewardManagerService;
import com.rewardomain.rewardsdiningdesktopclient.service.RewardManagerService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RewardFormController {
    IRewardManagerService service;
    @FXML
    private TextField cardNumberTF;
    @FXML
    private TextField merchantNumberTF;
    @FXML
    private TextField diningAmountTF;
    @FXML
    private TextField diningDateTF;

    public RewardFormController() {
        service = new RewardManagerService();
    }

    public void createReward() {
        String cardNumber = cardNumberTF.getText();
        long merchantNumber = Long.parseLong(merchantNumberTF.getText());
        double diningAmount = Double.parseDouble(diningAmountTF.getText());
        String diningDate = diningDateTF.getText();
        Dining dining = new Dining(cardNumber, merchantNumber, diningAmount, diningDate);
        try {
            Confirmation confirmation = service.createReward(dining);
            if(confirmation != null) {
                NotificationManager.showInfoNotification("Registration", "Reward confirmed !");
            }
            else {
                NotificationManager.showErrorNotification("Registration", "Reward confirmation failed !");
            }
        } catch (JsonProcessingException e) {
            NotificationManager.showErrorNotification("Error", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
