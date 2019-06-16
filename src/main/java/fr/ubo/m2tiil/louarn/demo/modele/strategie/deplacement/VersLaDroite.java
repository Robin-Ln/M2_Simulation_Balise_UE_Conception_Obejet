package fr.ubo.m2tiil.louarn.demo.modele.strategie.deplacement;

import fr.ubo.m2tiil.louarn.demo.vue.BaliseWorld;
import fr.ubo.m2tiil.louarn.demo.modele.Position;
import fr.ubo.m2tiil.louarn.demo.modele.strategie.StrategieDeplacement;

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