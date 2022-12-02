module com.example.hotelvangogh {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;
    requires java.mail;
    requires java.desktop;
    requires activation;


    opens controladores to javafx.fxml;
    opens connection to javafx.fxml;
    exports connection;
    exports  controladores;
}