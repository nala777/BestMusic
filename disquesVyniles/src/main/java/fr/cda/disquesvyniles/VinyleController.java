package fr.cda.disquesvyniles;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;


import fr.cda.disquesvyniles.util.scrol.LeBonCoin;
import fr.cda.disquesvyniles.util.scrol.CultureFactory;
import fr.cda.disquesvyniles.util.scrol.VinylCorner;
import fr.cda.disquesvyniles.util.scrol.MesVinyles;
import fr.cda.disquesvyniles.util.Mail;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.sql.Date;


/**
 * The type Vinyle controller.
 */
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
    private TextArea search;
    @FXML
    private Button closeBDD;

    /**
     * On close click.
     */
    @FXML
    protected void onCloseClick() {
        Platform.exit();
    }

    /**
     * On effacer click.
     */
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

    /**
     * Popup mail.
     */
    @FXML
    public void PopupMail(){
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);

        popupwindow.setTitle("Envoie Courriel");
        Label label1 = new Label("Saisie du courriel");
        Label label2 = new Label("Veuillez saisir l'email de l'expéditeur");
        TextField mail = new TextField();
        mail.setPromptText("destinataire@gmail.com");
        Button button1 = new Button("Envoyer");
        Button button2 = new Button("Annuler");

        button1.setOnAction(e -> {
            Mail.send(mail.getText(),search.getText());
            popupwindow.close();
        });
        button2.setOnAction(e -> popupwindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,label2,mail,button1,button2);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout,300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    @FXML
    public void exit(){
        Platform.exit();
    }

    @FXML
    public void PopupHelp(){
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Aide");
        TextArea aide = new TextArea("Cette application de Scrapping permet de faire une recherche avec un auteur , un prix min , un prix max, une année , un genre :\n" +
                "\n" +
                "1/Faire une recherche :\n" +
                "\n" +
                "Pour faire une recherche , il suffit de rentrer l'auteur rechercher, la date de sortie, un prix min et max et selectionner \n" +
                "les ou le site sur lequel rechercher\n" +
                "\n" +
                "2/ Enregistrer dans un fichier\n" +
                "\n" +
                "Après une recherche, il vous est possible de l'enregistrer dans un fichier texte à travers les menu en haut à droite\n" +
                "\n" +
                "3/ Envoie par mail\n" +
                "\n" +
                "La possibilité d'envoyer le résultat de la recherche par mail\n" +
                "\n" +
                "4/ Envoie en base de donnée du résultat\n" +
                "\n" +
                "En cours ") ;
        aide.setPrefHeight(800.00);
        aide.setPrefWidth(600.00);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(aide);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout,800, 600);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    /**
     * Popup save.
     */
    @FXML
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

    /**
     * Save search.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void SaveSearch() throws IOException {
        if (search.getText().equals("")||search.getText().equals("Aucune Recherche à enregistrer")){
            search.setText("Aucune Recherche à enregistrer");
        }else{
            String searchTxt = search.getText();
            try {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter =
                        new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                fileChooser.setInitialDirectory(new File("./"));
                fileChooser.setTitle("");
                File selectedFile = fileChooser.showSaveDialog(null);
                String path = selectedFile.getAbsolutePath();
                if (path!=null) {
                    PrintWriter ecrire = new PrintWriter(new BufferedWriter
                            (new FileWriter(path)));
                    ecrire.println(searchTxt);
                    ecrire.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    /**
     * Bdd scene.
     *
     * @throws IOException the io exception
     */
    @FXML
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
            search.setText("Erreur lors de l'enregistrement du fichier");
        }
    }

    /**
     * On fermer bdd click.
     */
    @FXML
    protected void onFermerBDDClick(){
        Stage stage = (Stage) closeBDD.getScene().getWindow();
        stage.close();
    }

    /**
     * Recherche and method call for differents websites
     */
    @FXML
    protected void recherche(){
        String searchTitle = titre.getText();
        String categorie = genre.getValue().toString();
        String searchDate = date.getValue()
                .toString()
                .substring(0,4);
        String searchPriceMin = prixMin.getText();
        String searchPriceMax = prixMax.getText();
        boolean searchDiscogs = discogs.isSelected();
        boolean searchFnac = fnac.isSelected();
        boolean searchVinylCorner = vinylCorner.isSelected();
        boolean searchLeboncoin = leboncoin.isSelected();
        boolean searchMesVinyles = mesVinyles.isSelected();
        boolean searchCultureFactory = cultureFactory.isSelected();
        String res = "";

        if(searchLeboncoin==true){
           res += LeBonCoin.ScrapLeboncoin(searchTitle,searchPriceMin,searchPriceMax);
        }

        if(searchCultureFactory==true){
            res += CultureFactory.scrapCultureFactory(searchTitle,searchPriceMin,searchPriceMax);
        }

        if (searchVinylCorner==true) {
            res += VinylCorner.scrapVinylCorner(searchTitle,searchPriceMin,searchPriceMax,categorie);
        }

        if (searchMesVinyles==true) {
            res += MesVinyles.scrapMesVinyles(searchTitle,searchPriceMin,searchPriceMax,searchDate);
        }
        search.setText(res);
    }



}