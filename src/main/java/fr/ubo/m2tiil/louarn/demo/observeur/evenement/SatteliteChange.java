package fr.ubo.m2tiil.louarn.demo.observeur.evenement;

import fr.ubo.m2tiil.louarn.demo.modele.Balise;
import fr.ubo.m2tiil.louarn.demo.modele.Sattelite;

public class SatteliteChange extends Evenement<Sattelite, Balise> {

    // Constructeur

    public SatteliteChange(Sattelite sattelite) {
        super(sattelite);
    }

    // Methodes

    @Override
    public void traitement(Balise balise) {
        balise.sendData(this.getSource());
    }

}
