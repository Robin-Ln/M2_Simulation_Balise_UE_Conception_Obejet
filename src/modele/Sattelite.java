package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import observeur.evenement.SatteliteChange;
import vue.BaliseWorld;

public class Sattelite extends Entite {

    public Sattelite(Modele modele, Integer x, Integer y) {
        super(modele);
        Position position = new Position(x, y);
        Deplacement deplacement = new VersLaDroite(BaliseWorld.vitesseSattelite, this);
        this.setPosition(position);
        this.setDeplacement(deplacement);
    }

    public void seDeplacer() {
        super.seDeplacer();
        this.signal(new SatteliteChange(this));
    }


    public void receiveData(Balise balise) {
        System.out.println(balise);
    }


}
