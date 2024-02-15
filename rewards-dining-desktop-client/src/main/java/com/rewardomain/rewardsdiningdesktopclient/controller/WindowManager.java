package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.rewardomain.rewardsdiningdesktopclient.HelloApplication;
import com.rewardomain.rewardsdiningdesktopclient.entity.Beneficiary;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class WindowManager {

private static WindowManager instance = new WindowManager();
    private WindowManager() {
    }

    public static WindowManager getInstance() {
        return instance;
    }

    public void showRestaurantForm(FlowPane pane) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RestaurantForm.fxml"));
        Scene scene = null;
        try {
            AnchorPane restaurantForm = fxmlLoader.load();
            RestaurantFormController controller = fxmlLoader.getController();
            controller.setPane(pane);
            scene = new Scene(restaurantForm, 495, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void showAccountForm(FlowPane pane) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccountForm.fxml"));
        Scene scene = null;
        try {
            AnchorPane accountForm = fxmlLoader.load();
            AccountFormController controller = fxmlLoader.getController();
            controller.setPane(pane);
            scene = new Scene(accountForm, 495, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void showBeneficiariesView(String accountNumber) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BeneficiariesView.fxml"));
        Scene scene = null;
        try {
            AnchorPane beneficiariesView = fxmlLoader.load();
            BeneficiariesViewController controller = fxmlLoader.getController();
            controller.initializeTable(accountNumber);
            scene = new Scene(beneficiariesView, 420, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void showBeneficiaryForm(String accountNumber, TableView<Beneficiary> tableView) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BeneficiaryForm.fxml"));
        Scene scene = null;
        try {
            AnchorPane beneficiaryForm = fxmlLoader.load();
            BeneficiaryFormController controller = fxmlLoader.getController();
            controller.setAccountNumber(accountNumber);
            controller.setTable(tableView);
            scene = new Scene(beneficiaryForm, 380, 181);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void showRewardForm() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RewardForm.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 450, 290);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
