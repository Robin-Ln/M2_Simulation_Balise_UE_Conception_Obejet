package modele;

import modele.deplacement.Deplacement;
import observeur.EntiteChange;
import observeur.Observable;
import observeur.SatteliteChange;

public abstract class Entite extends Observable {

    // Attributs

    private Position position;

    private Deplacement deplacement;

    // Constructeurs

    public Entite() {
        super();
    }


    // Methodes

    public void seDeplacer() {
        Position position = this.getDeplacement().nextPosition(this.getPosition());
        this.setPosition(position);
        this.signal(new SatteliteChange(this));
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
}
