module com.example.assignonejava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignonejava to javafx.fxml;
    exports com.example.assignonejava;
}