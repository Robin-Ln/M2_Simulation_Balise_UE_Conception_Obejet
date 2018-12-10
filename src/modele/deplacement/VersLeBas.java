package modele.deplacement;

import modele.Entite;
import modele.Position;
import vue.BaliseWorld;

public class VersLeBas extends Deplacement {

    public VersLeBas(Integer vitesse, Entite entite) {
        super(vitesse, entite);
    }

    @Override
    public Position nextPosition(Position position) {
        // calcule du X
        Integer nextX = (position.getX() + this.getVitesse()) % BaliseWorld.width;
        position.setX(nextX);

        // Calcule du Y
        if (position.getY() > BaliseWorld.height * 2) {
            this.getEntite().setDeplacement(new VersLeHaut(this.getVitesse(), this.getEntite()));
        } else {
            position.setY(position.getY() + this.getVitesse());
        }

        return position;
    }
}
