package modele;

import observeur.EntiteChange;
import observeur.Evenement;
import observeur.Observeur;
import observeur.SatteliteChange;
import vue.BaliseWorld;
import visiteur.VisitorEntite;

public class Balise extends Entite implements Observeur {

    /*public void seDeplacer(){
        Position position = this.getDeplacement().nextPosition(this);
        this.setPosition(position);
        this.signal(new SatteliteChange(this));
        this.signal(new EntiteChange(this));
    }*/

    public void seDeplacer(){
        Position position = this.getDeplacement().nextPosition(this.getPosition());
        this.setPosition(position);
        this.signal(new EntiteChange(this));
    }


    @Override
    public void receive(Evenement evt) {
        Sattelite sattelite = (Sattelite) evt.source();


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
