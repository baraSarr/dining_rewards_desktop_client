package com.rewardomain.rewardsdiningdesktopclient.controller;

import javafx.scene.control.Alert;

public class NotificationManager {
    public static void showErrorNotification(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.show();
    }

    public static void showInfoNotification(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.show();
    }

}
