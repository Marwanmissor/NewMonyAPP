package org.boshy.newmonyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Helwan2CN {
    @FXML
    private TextField AllTFH2, VisaTFH2, SWtfH2;
    @FXML
    private Button PrevButtonH2 , NextButtonH2;
    @FXML
    private CheckBox VisaCHH2 , SWCHH2 ;
    private Stage stage;
    private Scene scene;
    private Parent root;
   DataCollector Hl2 = new DataCollector();
@FXML
    public void Back(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("Helwan1.fxml"));
    stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setTitle("حلوان 1");
    stage.setScene(scene);
    stage.show();
    Data();
    file(Hl2.toString("حلوان 2"));
    }
    @FXML
    public void Next(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HaHelwan.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("حدايق حلوان");
        stage.setScene(scene);
        stage.show();
        Data();
       file(Hl2.toString("حلوان 2"));
    }
    public void enableVisa(){
        if (VisaCHH2.isSelected()){
            VisaTFH2.setDisable(false);

        }else
            VisaTFH2.setDisable(true);
    }
    public void enableSW(){
        if (SWCHH2.isSelected()){
            SWtfH2.setDisable(false);

        }else
            SWtfH2.setDisable(true);
    }
    private void Data() {

        if (AllTFH2.getText().isEmpty()) {
            Hl2.Helwan2.setTotal(0);
        } else {
            Hl2.Helwan2.setTotal(Float.parseFloat(AllTFH2.getText()));
        }

        if(VisaTFH2.isDisabled() || VisaTFH2.getText().isEmpty()){
            Hl2.Helwan2.setVisa(0);
        }else {
            Hl2.Helwan2.setVisa(Float.parseFloat(VisaTFH2.getText()));
        }

        if (SWtfH2.isDisabled() || SWtfH2.getText().isEmpty()){
            Hl2.Helwan2.setSmartWallet(0);
        }else {
            Hl2.Helwan2.setSmartWallet(Float.parseFloat(SWtfH2.getText()));
        }

    }
    public void file (String s)throws IOException{
        MyFile myFile = new MyFile();
        myFile.write(s);
        myFile.close();
    }
    }


