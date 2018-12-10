package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import vue.BaliseWorld;

public class Sattelite extends Entite {

    public Sattelite(Integer x, Integer y) {
        Position position2 = new Position(x, y);
        Deplacement deplacement2 = new VersLaDroite(BaliseWorld.vitesseSattelite, this);
        this.setPosition(position2);
        this.setDeplacement(deplacement2);
    }



    public void receiveData(Balise balise) {
        System.out.println("Data");
    }


}
