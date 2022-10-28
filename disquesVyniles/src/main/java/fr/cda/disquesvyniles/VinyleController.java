package fr.cda.disquesvyniles;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VinyleController {

    @FXML
    private MenuItem connection;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem register;
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
    private Button closeBDD;



    @FXML
    protected void onCloseClick() {
        Platform.exit();
    }
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

    public void PopupMail(){
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);

        popupwindow.setTitle("Envoie Courriel");
        Label label1 = new Label("Saisie du courriel");
        Label label2 = new Label("Veuillez saisir l'email de l'expéditeur");
        Button button1 = new Button("Envoyer");
        Button button2 = new Button("Annuler");
        button2.setOnAction(e -> popupwindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,label2,button1,button2);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout,300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public void PopupSave(){
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);

        popupwindow.setTitle("Transmission");
        Label label1 = new Label("Transmission des données à la base de données");
        Label label2 = new Label("Cliquer sur valider pour lancer la transmission :");
        Button button1 = new Button("Valider");
        Button button2 = new Button("Annuler");
        button2.setOnAction(e -> popupwindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,label2,button1,button2);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout,300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public void BDDScene() throws IOException {

        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VinyleApplication.class.getResource("ihmBDD.fxml"));
            Scene scene = new Scene(loader.load(), 600,400);
            Stage stage = new Stage();
            stage.setTitle("Paramètre de la base de données");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onFermerBDDClick(){
        Stage stage = (Stage) closeBDD.getScene().getWindow();
        stage.close();
    }

}