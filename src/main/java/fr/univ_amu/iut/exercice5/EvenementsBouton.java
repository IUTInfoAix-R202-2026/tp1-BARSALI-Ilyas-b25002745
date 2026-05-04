package fr.univ_amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EvenementsBouton extends Application {

  @Override
  public void start(Stage primaryStage) {
    Compteur compteur = new Compteur();

    Button bouton = new Button("Clique-moi");
    bouton.setId("bouton-clique-moi");

    Label labelCompteur = new Label("0 clics");
    labelCompteur.setId("compteur");

    bouton.setOnAction(
        e -> {
          compteur.incrementer();
          labelCompteur.setText(compteur.getValeur() + " clics");
        });

    VBox vbox = new VBox(bouton, labelCompteur);
    primaryStage.setScene(new Scene(vbox));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
