package modele.deplacement;

import modele.Position;
import vue.BaliseWorld;

public class VersLaDroite extends Deplacement {

    public VersLaDroite(Integer vitesse) {
        super(vitesse);
    }

    @Override
    public Position nextPosition(Position position) {
        Integer nextX = (position.getX() + this.getVitesse()) % BaliseWorld.width;
        position.setX(nextX);
        return position;
    }
}
