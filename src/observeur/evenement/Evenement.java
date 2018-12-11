package observeur.evenement;

import observeur.Observable;
import observeur.Observeur;

public abstract class Evenement<Source extends Observable, Cible extends Observeur> {

    // Attributs

    private Source source;

    // Constructeur

    public Evenement(Source source) {
        this.source = source;
    }

    // Methodes

    abstract public void traitement(Cible cible);

    // Accesseur


    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
