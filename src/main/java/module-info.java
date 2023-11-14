module com.example.kp_psp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kp_psp to javafx.fxml;
    exports com.example.kp_psp;
}