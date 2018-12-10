package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import observeur.EntiteChange;
import observeur.SatteliteChange;
import visiteur.VisitorEntite;
import vue.BaliseWorld;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sattelite extends Entite {

    public Sattelite(Integer x, Integer y, Integer vitesse) {
        Position position2 = new Position(x, y);
        Deplacement deplacement2 = new VersLaDroite(vitesse);
        this.setPosition(position2);
        this.setDeplacement(deplacement2);
    }

    @Override
    public void accept(VisitorEntite visitorEntite) {
        visitorEntite.visite(this);
    }

    public void receiveData(Balise balise) {
        System.out.println("Data");
    }


}
