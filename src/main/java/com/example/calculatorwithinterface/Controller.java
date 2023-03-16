package com.example.calculatorwithinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    TextField textField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void Solve(ActionEvent event) throws IOException {
        String inputField = textField.getText();
        Main main = new Main();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultScene.fxml"));
        root = loader.load();

        ResultController resultController = loader.getController();
        resultController.DisplayResult(inputField ,main.Calculation(inputField));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
