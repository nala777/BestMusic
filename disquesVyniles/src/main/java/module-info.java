module fr.cda.disquesvyniles {
    requires javafx.controls;
    requires javafx.fxml;
    requires sib.api.v3.sdk;

    requires htmlunit;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires dotenv.java;
    requires junit;
    requires org.testng;

    opens fr.cda.disquesvyniles to javafx.fxml;
    exports fr.cda.disquesvyniles;
    exports fr.cda.disquesvyniles.test;
}