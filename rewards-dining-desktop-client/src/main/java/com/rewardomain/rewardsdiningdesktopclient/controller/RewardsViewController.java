package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.HelloApplication;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.rewardomain.rewardsdiningdesktopclient.entity.Reward;
import com.rewardomain.rewardsdiningdesktopclient.service.IRewardManagerService;
import com.rewardomain.rewardsdiningdesktopclient.service.RewardManagerService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.List;

public class RewardsViewController {
    IRewardManagerService service;
    @FXML
    private FlowPane rewardsPane;

    public RewardsViewController() {
        service = new RewardManagerService();
    }

    @FXML
    private void initialize() {
        List<Reward> rewards;
        try {
            rewards = service.getRewards();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (Reward reward : rewards) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Reward.fxml"));
                rewardsPane.getChildren().add(fxmlLoader.load());
                RewardController rewardController = fxmlLoader.getController();
                rewardController.setup(reward);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addReward(){
        WindowManager manager = WindowManager.getInstance();
        manager.showRewardForm();
    }
}
