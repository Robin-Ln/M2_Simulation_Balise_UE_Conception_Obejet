package modele;

import observeur.EntiteChange;
import observeur.SatteliteChange;
import visiteur.VisitorEntite;

public class Sattelite extends Entite {

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
