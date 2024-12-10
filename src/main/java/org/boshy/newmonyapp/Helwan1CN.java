package org.boshy.newmonyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;


public class Helwan1CN {
    @FXML
    private TextField AllTFH1, VisaTFH1, SWtfH1;
    @FXML
    private Button FridayButtonH1, NextButtonH1;
    @FXML
    private CheckBox VisaCHH1, SWCHH1;
    private Stage stage;
    private Scene scene;
    private Parent root;
   DataCollector Hl1 = new DataCollector();
    @FXML
    private void Next(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Helwan2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("حلوان 2");
        stage.setScene(scene);
        stage.show();
        Data();
        file(Hl1.toString("حلوان 1"));
    }
@FXML


    public void enableVisa() {
        if (VisaCHH1.isSelected()) {
            VisaTFH1.setDisable(false);

        } else
            VisaTFH1.setDisable(true);
    }

    public void enableSW() {
        SWtfH1.setDisable(false);
        if (!SWCHH1.isSelected()){
            SWtfH1.setDisable(true);
        }
    }

    private void Data() {

        if (AllTFH1.getText().isEmpty()) {
            Hl1.Helwan1.setTotal(0);
        } else {
            Hl1.Helwan1.setTotal(Float.parseFloat(AllTFH1.getText()));
        }

        if(VisaTFH1.isDisabled() || VisaTFH1.getText().isEmpty()){
            Hl1.Helwan1.setVisa(0);
        }else {
            Hl1.Helwan1.setVisa((Float.parseFloat(VisaTFH1.getText())));
        }

        if (SWtfH1.isDisabled() || SWtfH1.getText().isEmpty()){
            Hl1.Helwan1.setSmartWallet(0);
        }else {
            Hl1.Helwan1.setSmartWallet(Float.parseFloat(SWtfH1.getText()));
        }

    }
    public void file (String s)throws IOException{
        MyFile myFile = new MyFile();
        myFile.write(s);
        myFile.close();
    }
}