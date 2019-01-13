package modele.strategie.deplacement;

import modele.Position;
import modele.strategie.StrategieDeplacement;
import vue.BaliseWorld;

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
