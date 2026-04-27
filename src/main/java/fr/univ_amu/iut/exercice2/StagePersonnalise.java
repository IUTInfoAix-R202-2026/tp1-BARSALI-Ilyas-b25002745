package fr.univ_amu.iut.exercice2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Exercice 2 - Stage personnalisé.
 *
 * <p>Objectif : personnaliser la fenêtre (titre, dimensions, redimensionnement, style de
 * décoration).
 *
 * <p>Concepts : propriétés de {@link Stage}, {@link javafx.stage.StageStyle}.
 */
public class StagePersonnalise extends Application {

  @Override
  public void start(Stage primaryStage) {
    // Les tests attendent, dans l'ordre conseillé :
    primaryStage.setTitle("Ma fenêtre personnalisée"); //   1. setTitle("Ma fenêtre personnalisée")
    primaryStage.setWidth(500);
    primaryStage.setHeight(300); //   2. setWidth(500) et setHeight(300)
    primaryStage.setResizable(false); //   3. setResizable(false)
    primaryStage.initStyle(
        StageStyle
            .UNDECORATED); //   4. initStyle(StageStyle.UNDECORATED)   ← à appeler avant show()
    primaryStage.show();
    // Active les tests un à un (retire @Disabled) et implémente au fur et
    // à mesure. N'oublie pas d'appeler show() à la fin.
  }

  public static void main(String[] args) {
    launch(args);
  }
}
