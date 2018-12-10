package modele.deplacement;

import modele.Entite;
import modele.Position;
import vue.BaliseWorld;

public class VersLaDroite extends Deplacement {

    public VersLaDroite(Integer vitesse, Entite entite) {
        super(vitesse, entite);
    }

    @Override
    public Position nextPosition(Position position) {
        Integer nextX = (position.getX() + this.getVitesse()) % BaliseWorld.width;
        position.setX(nextX);
        return position;
    }
}
