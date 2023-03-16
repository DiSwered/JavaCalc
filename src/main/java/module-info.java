module com.example.calculatorwithinterface {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorwithinterface to javafx.fxml;
    exports com.example.calculatorwithinterface;
}