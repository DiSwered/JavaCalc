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
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//
//        String[] s = str.split("[+\\-/*]");
//        String[] symb = Arrays.stream(str.split("\\d")).filter(x -> !x.isEmpty()).toArray(String[]::new);
//        int[] newStr = new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])};
//        int res = newStr[0];
//        for (int i = 1; i < s.length; i++) {
//            newStr[0] = res;
//            newStr[1] = Integer.parseInt(s[i]);
//            switch (symb[i - 1]) {
//                case "+" -> res = newStr[0] + newStr[1];
//                case "-" -> res = newStr[0] - newStr[1];
//                case "/" -> res = newStr[0] / newStr[1];
//                case "*" -> res = newStr[0] * newStr[1];
//            }
//        }
//        System.out.println(res);
        launch(args);
    }

    public int Calculation(String str) {
        String[] s = str.split("[+\\-/*]");
        if (s.length < 2) {
            return Integer.parseInt(s[0]);
        } else {
            String[] symb = Arrays.stream(str.split("\\d")).filter(x -> !x.isEmpty()).toArray(String[]::new);
            int[] newStr = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
            int res = newStr[0];
            for (int i = 1; i < s.length; i++) {
                newStr[0] = res;
                newStr[1] = Integer.parseInt(s[i]);
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
