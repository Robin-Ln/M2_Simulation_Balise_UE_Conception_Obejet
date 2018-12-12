package modele;

import modele.strategie.StrategieDeplacement;
import observeur.Observable;
import observeur.evenement.EntiteChange;

public abstract class Entite extends Observable {

    // Attributs

    private Position position;

    private StrategieDeplacement strategieDeplacement;

    private Modele modele;

    // Constructeurs

    public Entite(Modele modele) {
        super();
        this.modele = modele;
    }


    // Methodes

    public void seDeplacer() {
        this.strategieDeplacement.seDeplacer();
        this.signal(new EntiteChange(this));
    }

    // Accesseurs

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public StrategieDeplacement getStrategieDeplacement() {
        return strategieDeplacement;
    }

    public void setStrategieDeplacement(StrategieDeplacement strategieDeplacement) {
        this.strategieDeplacement = strategieDeplacement;
    }
}
