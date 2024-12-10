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
    DataCollector FR = new DataCollector();
@FXML
    public void Next(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HaHelwan.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("حدايق حلوان");
        stage.setScene(scene);
        stage.show();
        Data();
     //   file(FR.toString("الجمعه"));
    }
    @FXML
    public void Done(ActionEvent event) throws IOException, InterruptedException {
        MyFile myFile = new MyFile();
        Data();
      FR.getAll();
        myFile.write(FR.toString("الجمعه"));
        myFile.write( FR.TotalofALL());
        myFile.close();
        Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Thread.sleep(1000);
        currentStage.close();
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
        if (AllTFHF.getText().isEmpty()){
            FR.Friday.setTotal(0);
        }else {
            FR.Friday.setTotal(Float.parseFloat(AllTFHF.getText()));
        }

        if (VisaTFHF.isDisabled() || VisaTFHF.getText().isEmpty()){
            FR.Friday.setVisa(0);
        }else {
            FR.Friday.setVisa(Float.parseFloat(VisaTFHF.getText()));
        }

        if (SWtfHF.isDisabled() || SWtfHF.getText().isEmpty()){
            FR.Friday.setSmartWallet(0);
        }else {
            FR.Friday.setSmartWallet((Float.parseFloat(SWtfHF.getText())));
        }
     }
//    public void file (String s)throws IOException{
//        MyFile myFile = new MyFile();
//        myFile.write(s);
//    }
}

