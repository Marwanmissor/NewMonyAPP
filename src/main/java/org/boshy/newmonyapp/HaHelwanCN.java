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
    private Stage stage = new Stage();
    private Scene scene;
    private Parent root;
    DataCollector Hah = new DataCollector();

    public void Done(ActionEvent event) throws IOException, InterruptedException {
        MyFile myFile = new MyFile();
        Data();
        Hah.getAll();
        myFile.write(Hah.toString("حدايق حلوان"));
        myFile.write( Hah.TotalofALL());
        myFile.close();
        Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Thread.sleep(1000);
        currentStage.close();
    }

    @FXML
    private void Helwan2Buttom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Helwan2.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("حلوان 2");
        stage.setScene(scene);
        stage.show();
        Data();
        MyFile myFile = new MyFile();
        Hah.getAll();
        myFile.write(Hah.toString("حدايق حلوان"));
        myFile.write( Hah.TotalofALL());
    }
    @FXML
    public void Friday(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Friday.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("الجمعه");
        stage.setScene(scene);
        stage.show();
        MyFile myFile = new MyFile();
        Data();
        myFile.write(Hah.toString("حدايق حلوان"));

    }

    public void enableVisa() {
        if (VisaHHCH.isSelected()) {
            VisaHHTF.setDisable(false);
        } else
            VisaHHTF.setDisable(true);
    }
    public void enableSmartWallet(){
        if (SWHHCH.isSelected()){
            SWHHTF.setDisable(false);
        }else {SWHHTF.setDisable(true);}
    }
    public void Data() {
        if (AllTF.getText().isEmpty()) {
            Hah.HaHelwan.setTotal(0);
        } else {
            Hah.HaHelwan.setTotal(Float.parseFloat(AllTF.getText()));
        }

        if (VisaHHTF.isDisabled() || VisaHHTF.getText().isEmpty()) {
            Hah.HaHelwan.setVisa(0);
        } else {
            Hah.HaHelwan.setVisa((Float.parseFloat(VisaHHTF.getText())));
        }

        if (SWHHTF.isDisabled() || SWHHTF.getText().isEmpty()) {
            Hah.HaHelwan.setSmartWallet(0);
        } else {
            Hah.HaHelwan.setSmartWallet(Float.parseFloat(SWHHTF.getText()));
        }
    }

}

