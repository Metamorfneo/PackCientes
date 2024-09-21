module com.example.pcfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pcfx to javafx.fxml;
    exports com.example.pcfx;
}