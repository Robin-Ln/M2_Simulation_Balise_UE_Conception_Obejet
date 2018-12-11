package observeur.evenement;

import modele.Balise;
import modele.Sattelite;
import modele.deplacement.VersLeBas;
import observeur.Observable;
import observeur.Observeur;

public class SatteliteChange extends Evenement<Sattelite,Balise> {

  // Constructeur

  public SatteliteChange(Sattelite sattelite) {
    super(sattelite);
  }

  // Methodes

  @Override
  public void traitement(Balise balise) {
    balise.sendData(this.getSource());
  }

}
