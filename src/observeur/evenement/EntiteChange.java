package observeur.evenement;

import modele.Entite;
import vue.EntiteVue;

import java.awt.*;

public class EntiteChange extends Evenement<Entite, EntiteVue> {

  // Constructeur

  public EntiteChange(Entite entite) {
    super(entite);
  }

  // Methodes


  @Override
  public void traitement(EntiteVue entiteVue) {
    Point point = new Point(this.getSource().getPosition().getX(), this.getSource().getPosition().getY());
    entiteVue.setPosition(point);
  }
}
