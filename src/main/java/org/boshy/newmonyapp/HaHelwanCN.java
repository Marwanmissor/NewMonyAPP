package org.boshy.newmonyapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HaHelwanCN {
    @FXML
    Button BackToHelwan2 = new Button();
    @FXML
    private void Helwan2Buttom() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Helwan2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Helwan2");
        stage.setScene(scene);
        stage.show();
    }
}
