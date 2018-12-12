package modele;

import modele.strategie.DeplacementBaliseNormale;
import observeur.Observeur;
import observeur.evenement.SatteliteChange;
import vue.BaliseVue;
import vue.BaliseWorld;

public class Balise extends Entite implements Observeur {

    public Balise(Modele modele, Integer x, Integer y) {
        super(modele);

        // Position
        Position position = new Position(x, y);
        this.setPosition(position);

        // Deplacement
        this.setStrategieDeplacement(new DeplacementBaliseNormale(this,BaliseWorld.vitesseBalise));

        // Creation de la vue
        new BaliseVue(this, this.getModele().getBaliseWorld());
    }

    @Override
    public void seDeplacer() {

        // Deplacement avec la strategie
        super.seDeplacer();

        // Balise a la surface ?
        Integer baliseY = this.getPosition().getY();
        if (baliseY.equals(BaliseWorld.height)) {

            // abonement a tous les satelites
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
            this.getStrategieDeplacement().nextDeplacement();

            // desinscription
            for (Sattelite sattelite2 : this.getModele().getSattelites()){
                sattelite2.unRecord(SatteliteChange.class, this);
            }
        }

    }


}
