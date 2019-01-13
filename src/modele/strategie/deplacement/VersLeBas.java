package modele.strategie.deplacement;

import modele.Position;
import modele.strategie.StrategieDeplacement;
import vue.BaliseWorld;

public class VersLeBas extends Deplacement {

    private StrategieDeplacement strategieDeplacement;

    public VersLeBas(StrategieDeplacement strategieDeplacement) {
        this.strategieDeplacement = strategieDeplacement;
    }

    @Override
    public Position nextPosition(Position position) {
        // calcule du X
        Integer nextX = (position.getX() + this.strategieDeplacement.getVitesse()) % BaliseWorld.width;
        position.setX(nextX);

        // Calcule du Y
        if (position.getY() > BaliseWorld.height * 2) {
            this.strategieDeplacement.nextDeplacement();
        } else {
            position.setY(position.getY() + this.strategieDeplacement.getVitesse());
        }

        return position;
    }
}
