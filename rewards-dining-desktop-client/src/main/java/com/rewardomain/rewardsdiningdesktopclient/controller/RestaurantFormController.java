package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.HelloApplication;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.rewardomain.rewardsdiningdesktopclient.service.BeneficeRestaurantService;
import com.rewardomain.rewardsdiningdesktopclient.service.IBeneficeRestaurantService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class RestaurantFormController {

    private FlowPane pane;
    IBeneficeRestaurantService beneficeRestaurantService;
    @FXML
    private TextField merchantNumberTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField percentageTF;

    public RestaurantFormController() {
        beneficeRestaurantService = new BeneficeRestaurantService();
    }

    public FlowPane getPane() {
        return pane;
    }

    public void setPane(FlowPane pane) {
        this.pane = pane;
    }

    public void addRestaurant() {
        long merchantNumber = Long.parseLong(merchantNumberTF.getText());
        String name = nameTF.getText();
        double percentage = Double.parseDouble(percentageTF.getText());
        Restaurant restaurant = new Restaurant(merchantNumber, name, percentage);
        try {
            DefaultResponse response = beneficeRestaurantService.createRestaurant(restaurant);
            if(response.getCode() == 201) {
                NotificationManager.showInfoNotification("Inscription", "Restaurant added successfully !");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Restaurant.fxml"));
                pane.getChildren().add(fxmlLoader.load());
                RestaurantController restaurantController = fxmlLoader.getController();
                restaurantController.setup(restaurant);
            }
            else {
                NotificationManager.showErrorNotification("Inscription", "Restaurant addition failed !");
            }
        } catch (JsonProcessingException e) {
            NotificationManager.showErrorNotification("Error","Unable to send request");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
