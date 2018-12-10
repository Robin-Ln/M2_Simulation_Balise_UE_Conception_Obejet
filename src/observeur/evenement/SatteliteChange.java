package observeur.evenement;

import modele.Balise;
import modele.Sattelite;
import observeur.Observable;
import observeur.Observeur;

public class SatteliteChange extends Evenement {

  // Constructeur

  public SatteliteChange(Observable source) {
    super(source);
  }


  // Methodes

  @Override
  public void traitement(Observeur observeur) {
    Balise balise = null;
    Sattelite sattelite = null;
    try {
      sattelite = (Sattelite) this.getSource();
      balise = (Balise) observeur;
    }catch (Exception e){
      e.printStackTrace();
      return;
    }
    balise.sendData(sattelite);
  }

}
