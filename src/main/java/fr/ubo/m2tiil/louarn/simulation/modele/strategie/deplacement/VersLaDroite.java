package fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement;

import fr.ubo.m2tiil.louarn.simulation.modele.Position;
import fr.ubo.m2tiil.louarn.simulation.modele.strategie.StrategieDeplacement;
import fr.ubo.m2tiil.louarn.simulation.vue.BaliseWorld;

public class VersLaDroite extends Deplacement {

    private StrategieDeplacement strategieDeplacement;

    public VersLaDroite(StrategieDeplacement strategieDeplacement) {
        this.strategieDeplacement = strategieDeplacement;
    }

    @Override
    public Position nextPosition(Position position) {
        Integer nextX = (position.getX() + this.strategieDeplacement.getVitesse()) % BaliseWorld.width;
        position.setX(nextX);
        return position;
    }
}
