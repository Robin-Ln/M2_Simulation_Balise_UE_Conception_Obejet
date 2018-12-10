package modele.deplacement;

import modele.Entite;
import modele.Position;
import vue.BaliseWorld;

public class VersLeHaut extends Deplacement {

    public VersLeHaut(Integer vitesse, Entite entite) {
        super(vitesse, entite);
    }

    @Override
    public Position nextPosition(Position position) {
        // calcule du X
        Integer nextX = (position.getX() + this.getVitesse()) % BaliseWorld.width;
        position.setX(nextX);

        // Calcule du Y
        if (position.getY() <= BaliseWorld.height) {
            this.getEntite().setDeplacement(new VersLaDroite(this.getVitesse(), this.getEntite()));
        } else {
            position.setY(position.getY() - this.getVitesse());
        }

        return position;
    }
}
