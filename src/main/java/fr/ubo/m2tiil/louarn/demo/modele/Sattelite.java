package fr.ubo.m2tiil.louarn.demo.modele;

import fr.ubo.m2tiil.louarn.demo.modele.strategie.StrategieDeplacementSateliteNormale;
import fr.ubo.m2tiil.louarn.demo.observeur.evenement.SatteliteChange;
import fr.ubo.m2tiil.louarn.demo.vue.BaliseWorld;
import fr.ubo.m2tiil.louarn.demo.vue.SatteliteVue;

public class Sattelite extends Entite {

    public Sattelite(Modele modele, Integer x, Integer y) {
        super(modele);
        // Position
        Position position = new Position(x, y);
        this.setPosition(position);

        // Deplacement
        this.setStrategieDeplacement(new StrategieDeplacementSateliteNormale(this, BaliseWorld.vitesseSattelite));


        // Creation de la java.fr.ubo.m2tiil.louarn.vue
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
