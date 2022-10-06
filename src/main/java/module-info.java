module com.example.chessgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.chessgame to javafx.fxml;
    exports com.example.chessgame;
}