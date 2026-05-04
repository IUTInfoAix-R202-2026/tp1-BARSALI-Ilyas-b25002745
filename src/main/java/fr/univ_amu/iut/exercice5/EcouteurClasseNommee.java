package fr.univ_amu.iut.exercice5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurClasseNommee implements EventHandler<ActionEvent> {

  private final Compteur compteur;

  public EcouteurClasseNommee(Compteur compteur) {
    this.compteur = compteur;
  }

  @Override
  public void handle(ActionEvent event) {
    compteur.incrementer();
  }
}
