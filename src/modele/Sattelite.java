package modele;

import modele.strategie.StrategieDeplacementSateliteNormale;
import observeur.evenement.SatteliteChange;
import vue.BaliseWorld;
import vue.SatteliteVue;

public class Sattelite extends Entite {

    public Sattelite(Modele modele, Integer x, Integer y) {
        super(modele);
        // Position
        Position position = new Position(x, y);
        this.setPosition(position);

        // Deplacement
        this.setStrategieDeplacement(new StrategieDeplacementSateliteNormale(this,BaliseWorld.vitesseSattelite));


        // Creation de la vue
        new SatteliteVue(this, this.getModele().getBaliseWorld());
    }

    public void seDeplacer() {
        super.seDeplacer();
        this.signal(new SatteliteChange(this));
    }


    public void receiveData(Balise balise) {
        System.out.println(balise);
    }


}
