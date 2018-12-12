package modele;

import modele.deplacement.Deplacement;
import observeur.Observable;
import observeur.evenement.EntiteChange;

public abstract class Entite extends Observable {

    // Attributs

    private Position position;

    private Deplacement deplacement;

    private Modele modele;

    // Constructeurs

    public Entite(Modele modele) {
        super();
        this.modele = modele;
    }


    // Methodes

    public void seDeplacer() {
        Position position = this.getDeplacement().nextPosition(this.getPosition());
        this.setPosition(position);
        this.signal(new EntiteChange(this));
    }

    // Accesseurs

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Deplacement getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(Deplacement deplacement) {
        this.deplacement = deplacement;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
}
