module fr.cda.disquesvyniles {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens fr.cda.disquesvyniles to javafx.fxml;
    exports fr.cda.disquesvyniles;
}