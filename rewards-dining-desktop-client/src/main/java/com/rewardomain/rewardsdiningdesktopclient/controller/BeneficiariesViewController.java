package com.rewardomain.rewardsdiningdesktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.Beneficiary;
import com.rewardomain.rewardsdiningdesktopclient.service.AccountContributionService;
import com.rewardomain.rewardsdiningdesktopclient.service.IAccountContributionService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BeneficiariesViewController {
    private String accountNumber;
    private IAccountContributionService service;
    @FXML
    private TableView<Beneficiary> beneficiariesTable;
    @FXML
    private TableColumn<Beneficiary, String> nameColumn;
    @FXML
    private TableColumn<Beneficiary, String> percentageColumn;
    @FXML
    private TableColumn<Beneficiary, String> savingsColumn;

    public BeneficiariesViewController() {
        service = new AccountContributionService();
    }

    public void initializeTable(String accountNumber) {
        this.accountNumber = accountNumber;
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        percentageColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPercentage()+""));
        savingsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSavings()+""));
        ObservableList<Beneficiary> beneficiaries = FXCollections.observableArrayList();
        try {
            beneficiaries.addAll(service.getBeneficiaries(accountNumber));
            beneficiariesTable.setItems(beneficiaries);
        } catch (JsonProcessingException e) {
            NotificationManager.showErrorNotification("Error", "Unable to fetch beneficiaries");
        }
    }

    public void showForm() {
        WindowManager manager = WindowManager.getInstance();
        manager.showBeneficiaryForm(accountNumber, beneficiariesTable);
    }

    public void showUpdateForm() {

    }
}
