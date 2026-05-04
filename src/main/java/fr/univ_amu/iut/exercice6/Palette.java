package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

  @Override
  public void start(Stage primaryStage) {

    // TODO exercice 6 : implémenter la palette décrite dans la Javadoc.
    //
    // Stratégie conseillée :
    //
    // 1. Créer un BorderPane comme racine.
    //
    // 2. Top : un HBox avec trois boutons "Rouge", "Vert", "Bleu".
    //    Donne-leur les ids "btn-rouge", "btn-vert", "btn-bleu" - les tests
    //    les retrouvent via robot.lookup("#btn-rouge") etc.
    //
    // 3. Center : un Pane avec l'id "zone", taille minimale 300×200.
    //    Change sa couleur via setStyle("-fx-background-color: red;") etc.
    //
    // 4. Bottom : un Label avec l'id "compteurs", texte initial
    //    "Rouge: 0  Vert: 0  Bleu: 0".
    //
    // 5. Trois entiers compteur_rouge, compteur_vert, compteur_bleu
    //    (ou trois variables d'instance). Chaque clic incrémente le bon
    //    compteur et reformate le texte du label.
    //
    // 6. Attention au format du texte du label : les tests vérifient la
    //    présence exacte des substrings "Rouge: 2", "Vert: 0", "Bleu: 1"
    //    après une séquence de clics.
    BorderPane borderPane = new BorderPane();

    Button btnRouge = new Button("Rouge");
    btnRouge.setId("btn-rouge");

    Button btnVert = new Button("Vert");
    btnVert.setId("btn-vert");

    Button btnBleu = new Button("Bleu");
    btnBleu.setId("btn-bleu");

    HBox hbox = new HBox(btnRouge, btnVert, btnBleu);
    borderPane.setTop(hbox);

    Pane zone = new Pane();
    zone.setId("zone");
    zone.setMinSize(300, 200);
    borderPane.setCenter(zone);

    Label compteurs = new Label("Rouge: 0  Vert: 0  Bleu: 0");
    compteurs.setId("compteurs");
    borderPane.setBottom(compteurs);

    int[] cRouge = {0};
    int[] cVert = {0};
    int[] cBleu = {0};

    btnRouge.setOnAction(
        e -> {
          zone.setStyle("-fx-background-color: red;");
          cRouge[0]++;
          compteurs.setText("Rouge: " + cRouge[0] + "  Vert: " + cVert[0] + "  Bleu: " + cBleu[0]);
        });

    btnVert.setOnAction(
        e -> {
          zone.setStyle("-fx-background-color: green;");
          cVert[0]++;
          compteurs.setText("Rouge: " + cRouge[0] + "  Vert: " + cVert[0] + "  Bleu: " + cBleu[0]);
        });

    btnBleu.setOnAction(
        e -> {
          zone.setStyle("-fx-background-color: blue;");
          cBleu[0]++;
          compteurs.setText("Rouge: " + cRouge[0] + "  Vert: " + cVert[0] + "  Bleu: " + cBleu[0]);
        });

    primaryStage.setScene(new Scene(borderPane));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
