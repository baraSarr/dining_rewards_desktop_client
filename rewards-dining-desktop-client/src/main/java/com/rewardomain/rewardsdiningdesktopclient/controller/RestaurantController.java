package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.rewardomain.rewardsdiningdesktopclient.service.BeneficeRestaurantService;
import com.rewardomain.rewardsdiningdesktopclient.service.IBeneficeRestaurantService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RestaurantController {

    IBeneficeRestaurantService beneficeRestaurantService;

    private Restaurant restaurant;
    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label percentageLabel;
    @FXML
    private Label availabilityLabel;
    @FXML
    private Button availabilityButton;

    public RestaurantController() {
        beneficeRestaurantService = new BeneficeRestaurantService();
    }

    @FXML
    private void initialize() {

    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setup(Restaurant restaurant) {
        this.restaurant = restaurant;
        numberLabel.setText(String.valueOf(restaurant.getNumber()));
        nameLabel.setText(restaurant.getName());
        percentageLabel.setText(String.valueOf(restaurant.getPercentage()));
        availabilityLabel.setText(restaurant.getAvailability());
        switchButtonText();
    }

    public void changeAvailability() {
        if(restaurant.getAvailability().equals("allowed")) {
            restaurant.setAvailability("not_allowed");
        }
        else {
            restaurant.setAvailability("allowed");
        }
        DefaultResponse response;
        try {
            response = beneficeRestaurantService.updateRestaurant(restaurant);
            availabilityLabel.setText(restaurant.getAvailability());
            Alert alert;
            if(response.getCode() == 201) {
                NotificationManager.showInfoNotification("Availability change", "Availability change successful !");
            }
            else {
                NotificationManager.showErrorNotification("Availability change", "Availability change failed !");
            }
            switchButtonText();
        } catch (JsonProcessingException e) {
            NotificationManager.showErrorNotification("Error", "Unable to send request");
            e.printStackTrace();
        }
    }

    private void switchButtonText() {
        if(restaurant.getAvailability().equals("allowed")) {
            availabilityButton.setText("Suspend");
        }
        else {
            availabilityButton.setText("Restore");
        }
    }
}
