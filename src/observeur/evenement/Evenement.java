package observeur.evenement;

import observeur.Observable;
import observeur.Observeur;

public abstract class Evenement {

  // Attributs

  private Observable source;

  // Constructeur

  public Evenement(Observable source) {
    this.source = source;
  }

  // Methodes

 abstract public void traitement(Observeur observeur);

  // Accesseur


  public Observable getSource() {
    return source;
  }

  public void setSource(Observable source) {
    this.source = source;
  }
}
