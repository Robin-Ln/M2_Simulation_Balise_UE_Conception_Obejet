package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import observeur.EntiteChange;
import observeur.SatteliteChange;
import visiteur.VisitorEntite;
import vue.BaliseWorld;

public class Sattelite extends Entite {

    public Sattelite(Integer x, Integer y, Integer vitesse) {
        Position position2 = new Position(x, y);
        Deplacement deplacement2 = new VersLaDroite(vitesse);
        this.setPosition(position2);
        this.setDeplacement(deplacement2);
    }

    public void seDeplacer(){
        Position position = this.getDeplacement().nextPosition(this.getPosition());
        this.setPosition(position);
        this.signal(new SatteliteChange(this));
        this.signal(new EntiteChange(this));
    }

    @Override
    public void accept(VisitorEntite visitorEntite) {
        visitorEntite.visite(this);
    }

    public void receiveData(Balise balise) {
        System.out.println("Data");
    }


}
