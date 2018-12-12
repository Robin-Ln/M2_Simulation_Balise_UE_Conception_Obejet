package modele.deplacement;

import modele.Position;

public abstract class Deplacement {


    public Deplacement() {
    }

    public abstract Position nextPosition(Position position);
}
