package modele;

import modele.deplacement.Deplacement;
import observeur.*;
import visiteur.Visitable;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entite extends Observable implements Visitable {

    // Attributs

    private Position position;

    private Deplacement deplacement;

    // Constructeurs

    public Entite() {
        super();
    }


    // Methodes

    public void seDeplacer(){
        Position position = this.getDeplacement().nextPosition(this.getPosition());
        this.setPosition(position);
        List<Object> objects1 = new ArrayList<>();
        objects1.add(new Point(this.getPosition().getX(), this.getPosition().getY()));
        List<Object> objects2 = new ArrayList<>();
        objects2.add(this);
        this.signal(new SatteliteChange(this), objects2);
        this.signal(new EntiteChange(this), objects1);
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
