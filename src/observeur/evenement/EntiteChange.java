package observeur.evenement;

import modele.Entite;
import observeur.Observable;
import observeur.Observeur;
import vue.EntiteVue;

import java.awt.*;

public class EntiteChange extends Evenement {

  // Constructeur

  public EntiteChange(Observable source) {
    super(source);
  }


  // Methodes

  @Override
  public void traitement(Observeur observeur) {
    Entite entite = null;
    EntiteVue entiteVue = null;
    try {
      entite = (Entite) this.getSource();
      entiteVue = (EntiteVue) observeur;
    }catch (Exception e){
      e.printStackTrace();
      return;
    }
    Point point = new Point(entite.getPosition().getX(), entite.getPosition().getY());
    entiteVue.setPosition(point);
  }
}
