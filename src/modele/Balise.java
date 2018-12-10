package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import observeur.Observeur;
import vue.BaliseWorld;

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


}
