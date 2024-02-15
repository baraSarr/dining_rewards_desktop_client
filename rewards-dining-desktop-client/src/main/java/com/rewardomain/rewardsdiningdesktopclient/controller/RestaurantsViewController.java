package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.HelloApplication;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.rewardomain.rewardsdiningdesktopclient.service.BeneficeRestaurantService;
import com.rewardomain.rewardsdiningdesktopclient.service.IBeneficeRestaurantService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import java.io.IOException;
import java.util.List;

public class RestaurantsViewController {

    IBeneficeRestaurantService beneficeRestaurantService;
    @FXML
    private FlowPane restaurantsPane;

    public RestaurantsViewController() {
        beneficeRestaurantService = new BeneficeRestaurantService();
    }

    @FXML
    private void initialize() {
        List<Restaurant> restaurants;
        try {
            restaurants = beneficeRestaurantService.getRestaurants();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        restaurantsPane.getChildren().clear();
        for (Restaurant restaurant : restaurants) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Restaurant.fxml"));
                restaurantsPane.getChildren().add(fxmlLoader.load());
                RestaurantController restaurantController = fxmlLoader.getController();
                restaurantController.setup(restaurant);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void addRestaurant() {
        WindowManager manager = WindowManager.getInstance();
        manager.showRestaurantForm(restaurantsPane);
    }
}
