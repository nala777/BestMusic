package fr.cda.disquesvyniles;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class VinyleController {
    @FXML
    private TextField titre;
    @FXML
    private ComboBox genre;
    @FXML
    private DatePicker date;
    @FXML
    private TextField prixMax;
    @FXML
    private TextField prixMin;

    @FXML
    private CheckBox discogs;
    @FXML
    private CheckBox fnac;
    @FXML
    private CheckBox vinylCorner;
    @FXML
    private CheckBox leboncoin;
    @FXML
    private CheckBox mesVinyles;
    @FXML
    private CheckBox cultureFactory;
    @FXML
    private Button valider;
    @FXML
    private Button effacer;



    @FXML
    protected void onEffacerClick(){
        titre.setText("");
        genre.setValue(null);
        date.setValue(null);
        prixMax.setText("");
        prixMin.setText("");
        discogs.setSelected(false);
        fnac.setSelected(false);
        vinylCorner.setSelected(false);
        leboncoin.setSelected(false);
        mesVinyles.setSelected(false);
        cultureFactory.setSelected(false);
    }





}