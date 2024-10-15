package org.boshy.newmonyapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Helwan1CN {
    @FXML
    private Label NameH1;
    private ImageView logoH1;
    private Label AllLabelH1;
    private Label TotalH1;
    private Label VisaLabelH1;
    private Label SWLabelH1;
    private TextField AllTFH1;
    @FXML
    private TextField VisaTFH1;
    private TextField SWtfH1;
    private Button FridayButtonH1;
    private Button NextButtonH1;
    @FXML
    private RadioButton VisaCHH1;
    private Checkbox SWCHH1;
    @FXML
    private void Helwan2Buttom() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Helwan2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Helwan2");
        stage.setScene(scene);
        stage.show();
    }
    public void enable(){
        if (VisaCHH1.isSelected()){
            VisaTFH1.setDisable(false);

        }
    }
}