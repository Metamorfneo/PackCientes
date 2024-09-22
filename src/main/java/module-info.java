module com.example.pcfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.example.pcfx to javafx.fxml;
    exports com.example.pcfx;
}