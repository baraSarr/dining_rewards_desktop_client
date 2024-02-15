package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.entity.Reward;
import com.rewardomain.rewardsdiningdesktopclient.service.RewardManagerService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class RewardController {
    RewardManagerService service;
    Reward reward;
    @FXML
    private Label confirmationNumberLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label merchantNumberLabel;
    @FXML
    private Label dateLabel;

    public RewardController() {
        service = new RewardManagerService();
    }

    public void setup(Reward reward) {
        this.reward = reward;
        confirmationNumberLabel.setText(reward.getConfirmationNumber()+"");
        amountLabel.setText(reward.getAmount()+"");
        merchantNumberLabel.setText(reward.getMerchantNumber()+"");
        dateLabel.setText(reward.getRewardDate().toString());
    }

    public void distribute() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Reward distribution");
        dialog.setHeaderText("type the credit card number :");
        dialog.setContentText("Credit card number :");
        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()) {
            try {
                DefaultResponse response = service.distribute(result.get(), reward.getConfirmationNumber());
                if(response.getCode() == 200) {
                    NotificationManager.showInfoNotification("Distribution", "Distribution done !");
                }
                else {
                    NotificationManager.showErrorNotification("Distribution", "Distribution failed !");
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
