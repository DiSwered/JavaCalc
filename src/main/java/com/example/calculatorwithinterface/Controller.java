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
    private Main main = new Main();

    public void solve(ActionEvent event) throws IOException {
        String inputField = textField.getText();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultScene.fxml"));
        root = loader.load();

        ResultController resultController = loader.getController();
        resultController.DisplayResult(inputField ,main.Calculation(inputField));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addToInput(ActionEvent event) {
        String inputField = textField.getText();
        String buttonId = ((Node)event.getSource()).getId();
        switch (buttonId) {
            case "buttonOne" -> textField.setText(inputField + "1");
            case "buttonTwo" -> textField.setText(inputField + "2");
            case "buttonThree" -> textField.setText(inputField + "3");
            case "buttonFour" -> textField.setText(inputField + "4");
            case "buttonFive" -> textField.setText(inputField + "5");
            case "buttonSix" -> textField.setText(inputField + "6");
            case "buttonSeven" -> textField.setText(inputField + "7");
            case "buttonEight" -> textField.setText(inputField + "8");
            case "buttonNine" -> textField.setText(inputField + "9");
            case "buttonZero" -> textField.setText(inputField + "0");
            case "buttonPlus" -> textField.setText(inputField + "+");
            case "buttonMinus" -> textField.setText(inputField + "-");
            case "buttonMult" -> textField.setText(inputField + "*");
            case "buttonDiv" -> textField.setText(inputField + "/");
            case "buttonDEL" -> textField.setText(inputField.substring(0, inputField.length() - 1));
        }
        if (buttonId.equals("buttonPlus") || buttonId.equals("buttonMinus") || buttonId.equals("buttonDiv") || buttonId.equals("buttonMult")) {
            String resStr = Integer.toString(main.Calculation(inputField));
            textField.setText(resStr);
        }
    }
}
