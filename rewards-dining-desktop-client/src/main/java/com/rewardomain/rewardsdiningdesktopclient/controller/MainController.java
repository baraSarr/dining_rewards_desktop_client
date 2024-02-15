package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.rewardomain.rewardsdiningdesktopclient.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView logo;

    @FXML
    private void initialize() {
        Image image = new Image("file:C:\\Users\\FX506\\Documents\\MPISI2\\Integration_de_services\\logo.jpg");
        logo.setImage(image);
        showRestaurantsView();
    }

    public void showRestaurantsView() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RestaurantsView.fxml"));
        try {
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            NotificationManager.showErrorNotification("Error", "Unable to load restaurants page");
            e.printStackTrace();
        }
    }

    public void showAccountsView() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccountsView.fxml"));
        try {
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            NotificationManager.showErrorNotification("Error", "Unable to load accounts page");
            e.printStackTrace();
        }
    }

    public void showRewardsView() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RewardsView.fxml"));
        try {
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            NotificationManager.showErrorNotification("Error", "Unable to load rewards page");
            e.printStackTrace();
        }
    }
}
