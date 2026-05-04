package fr.univ_amu.iut.exercice5;

import static org.assertj.core.api.Assertions.assertThat;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class EvenementsBoutonTest {

  private Stage stage;

  @Start
  void start(Stage stage) throws Exception {
    this.stage = stage;
    new EvenementsBouton().start(stage);
  }

  @Test
  void laFenetreEstVisible(FxRobot robot) {
    assertThat(stage.isShowing()).isTrue();
  }

  @Test
  void laSceneExiste(FxRobot robot) {
    assertThat(stage.getScene()).isNotNull();
  }

  @Test
  void laRacineEstUnVBox(FxRobot robot) {
    assertThat(stage.getScene().getRoot()).isInstanceOf(VBox.class);
  }

  @Test
  void leBoutonExiste(FxRobot robot) {
    Button bouton = robot.lookup("#bouton-clique-moi").queryAs(Button.class);
    assertThat(bouton).isNotNull();
  }

  @Test
  void leBoutonAfficheLeBonTexte(FxRobot robot) {
    Button bouton = robot.lookup("#bouton-clique-moi").queryAs(Button.class);
    assertThat(bouton.getText()).isEqualTo("Clique-moi");
  }

  @Test
  void leLabelCompteurExiste(FxRobot robot) {
    Label compteur = robot.lookup("#compteur").queryAs(Label.class);
    assertThat(compteur).isNotNull();
  }

  @Test
  void leLabelAfficheZeroClicsInitialement(FxRobot robot) {
    Label compteur = robot.lookup("#compteur").queryAs(Label.class);
    assertThat(compteur.getText()).isEqualTo("0 clics");
  }

  @Test
  void troisClicsAffichent3Clics(FxRobot robot) {
    Button bouton = robot.lookup("#bouton-clique-moi").queryAs(Button.class);
    robot.interact(bouton::fire);
    robot.interact(bouton::fire);
    robot.interact(bouton::fire);

    Label compteur = robot.lookup("#compteur").queryAs(Label.class);
    assertThat(compteur.getText()).isEqualTo("3 clics");
  }
}
