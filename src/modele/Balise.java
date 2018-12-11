package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLeBas;
import modele.deplacement.VersLeHaut;
import observeur.Observeur;
import observeur.evenement.SatteliteChange;
import vue.BaliseWorld;

public class Balise extends Entite implements Observeur {

    public Balise(Modele modele, Integer x, Integer y) {
        super(modele);
        Position position = new Position(x, y);
        Deplacement deplacement = new VersLeHaut(BaliseWorld.vitesseBalise, this);
        this.setPosition(position);
        this.setDeplacement(deplacement);
    }

    @Override
    public void seDeplacer() {
        super.seDeplacer();

        Integer baliseY = this.getPosition().getY();

        // Balise a la surface
        if (baliseY.equals(BaliseWorld.height)) {

            for (Sattelite sattelite : this.getModele().getSattelites()){
                sattelite.record(SatteliteChange.class,this);
            }
        }

    }

    public void sendData(Sattelite sattelite) {
        Integer baliseX = this.getPosition().getX();
        Integer satteliteX = sattelite.getPosition().getX();

        // Sattelite positionné au dessus de la balise
        if (baliseX > satteliteX - 5 && baliseX < satteliteX + 5) {

            // envoir des donner
            sattelite.receiveData(this);

            // Changement de deplacement
            this.setDeplacement(new VersLeBas(BaliseWorld.vitesseBalise, this));

            // desinscription
            for (Sattelite sattelite2 : this.getModele().getSattelites()){
                sattelite2.unRecord(SatteliteChange.class, this);
            }
        }

    }


}
