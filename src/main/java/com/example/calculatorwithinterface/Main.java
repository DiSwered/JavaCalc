package com.example.calculatorwithinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public double Calculation(String str) {
        String[] s = str.split("[+\\-/*]");
        if (s.length < 2) {
            return Double.parseDouble(s[0]);

        } else {
            String[] symb = Arrays.stream(str.split("[.\\d]")).filter(x -> !x.isEmpty()).toArray(String[]::new);
            double[] newStr = new double[]{Float.parseFloat(s[0]), Float.parseFloat(s[1])};
            double res = newStr[0];
            for (int i = 1; i < s.length; i++) {
                newStr[0] = res;
                newStr[1] = Float.parseFloat(s[i]);
                switch (symb[i - 1]) {
                    case "+" -> res = newStr[0] + newStr[1];
                    case "-" -> res = newStr[0] - newStr[1];
                    case "/" -> res = newStr[0] / newStr[1];
                    case "*" -> res = newStr[0] * newStr[1];
                }
            }
            return res;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalculatorScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
