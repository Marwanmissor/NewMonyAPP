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

public class Friday {
    @FXML
    private TextField AllTFHF, VisaTFHF, SWtfHF;
    @FXML
    private Button NextButton;
    @FXML
    private CheckBox VisaCHHF, SWCHHF;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Data FR = new Data();

    public void NEx(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Helwan1.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("حلوان 1");
        stage.setScene(scene);
        stage.show();
        Data();
    }

    public void EnableVisa(){
        VisaTFHF.setDisable(false);
       if(! VisaCHHF.isSelected()) VisaTFHF.setDisable(true);
    }

    public void EnableSmartWallet(){
        SWtfHF.setDisable(false);
        if(! SWCHHF.isSelected()) SWtfHF.setDisable(true);
    }
    private void Data(){
        FR.setBranchName("الجمعه حلوان 1");
        if (AllTFHF.getText().isEmpty()){
            FR.setTotal(0);
        }else {
            FR.setTotal(Float.parseFloat(AllTFHF.getText()));
        }

        if (VisaTFHF.isDisabled() || VisaTFHF.getText().isEmpty()){
            FR.setVisa(0);
        }else {
            FR.setVisa(Float.parseFloat(VisaTFHF.getText()));
        }

        if (SWtfHF.isDisabled() || SWtfHF.getText().isEmpty()){
            FR.setSmartWallet(0);
        }else {
            try{
            FR.setSmartWallet(Float.parseFloat(SWtfHF.getText()));
        }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
