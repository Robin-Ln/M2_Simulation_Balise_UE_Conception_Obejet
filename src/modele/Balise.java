package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import observeur.EntiteChange;
import observeur.Evenement;
import observeur.Observeur;
import observeur.SatteliteChange;
import vue.BaliseWorld;
import visiteur.VisitorEntite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Balise extends Entite implements Observeur {

    public Balise(Integer x, Integer y, Integer vitesse) {
        Position position = new Position(x, y);
        Deplacement deplacement = new VersLaDroite(vitesse);
        this.setPosition(position);
        this.setDeplacement(deplacement);
    }



    public void sendData(Sattelite sattelite) {
        Integer baliseX = this.getPosition().getX();
        Integer satteliteX = sattelite.getPosition().getX();

        Integer baliseY = this.getPosition().getY();

        // Balise a la surface
        if (baliseY.equals(BaliseWorld.height)) {
            // Sattelite positionné au dessus de la balise
            if (baliseX > satteliteX - 5 && baliseX < satteliteX + 5) {
                sattelite.receiveData(this);
            }
        }
    }

    @Override
    public void accept(VisitorEntite visitorEntite) {
        visitorEntite.visite(this);
    }
}
