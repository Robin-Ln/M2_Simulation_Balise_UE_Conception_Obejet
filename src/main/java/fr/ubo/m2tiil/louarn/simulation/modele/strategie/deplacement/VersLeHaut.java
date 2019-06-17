package fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement;

import fr.ubo.m2tiil.louarn.simulation.modele.Position;
import fr.ubo.m2tiil.louarn.simulation.modele.strategie.StrategieDeplacement;
import fr.ubo.m2tiil.louarn.simulation.vue.BaliseWorld;

public class VersLeHaut extends Deplacement {

    private StrategieDeplacement strategieDeplacement;

    public VersLeHaut(StrategieDeplacement strategieDeplacement) {
        this.strategieDeplacement = strategieDeplacement;
    }

    @Override
    public Position nextPosition(Position position) {
        // calcule du X
        Integer nextX = (position.getX() + this.strategieDeplacement.getVitesse()) % BaliseWorld.width;
        position.setX(nextX);

        // Calcule du Y
        if (position.getY() <= BaliseWorld.height) {
            this.strategieDeplacement.nextDeplacement();
        } else {
            position.setY(position.getY() - this.strategieDeplacement.getVitesse());
        }

        return position;
    }
}
