module fr.cda.disquesvyniles {
    requires javafx.controls;
    requires javafx.fxml;
    requires sib.api.v3.sdk;

    requires htmlunit;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires dotenv.java;

    opens fr.cda.disquesvyniles to javafx.fxml;
    exports fr.cda.disquesvyniles;
}