package org.boshy.newmonyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HaHelwanCN {
    @FXML
    private Button Done, PrevButton;
    @FXML
    private TextField AllTF, VisaHHTF, SWHHTF;
    @FXML
    private CheckBox VisaHHCH, SWHHCH;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Data HHL = new Data();

    @FXML
    private void Helwan2Buttom(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Helwan2.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("حلوان 2");
        stage.setScene(scene);
        stage.show();
        Data();
        System.out.println(HHL.toString());
    }

    public void enableVisa() {
        if (VisaHHCH.isSelected()) {
            VisaHHTF.setDisable(false);
        } else
            VisaHHTF.setDisable(true);
    }

    public void Data() {
        HHL.setBranchName("حدايق حلوان");
        if (AllTF.getText().isEmpty()) {
            HHL.setTotal(0);
        } else {
            HHL.setTotal(Float.parseFloat(AllTF.getText()));
        }

        if (VisaHHTF.isDisabled() || VisaHHTF.getText().isEmpty()) {
            HHL.setVisa(0);
        } else {
            HHL.setVisa(Float.parseFloat(VisaHHTF.getText()));
        }

        if (SWHHTF.isDisabled() || SWHHTF.getText().isEmpty()) {
            HHL.setSmartWallet(0);
        } else {
            HHL.setSmartWallet(Float.parseFloat(SWHHTF.getText()));
        }
    }
}
