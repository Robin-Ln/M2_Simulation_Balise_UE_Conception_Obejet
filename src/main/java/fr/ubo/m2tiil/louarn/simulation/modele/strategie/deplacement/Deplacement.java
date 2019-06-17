package fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement;

import fr.ubo.m2tiil.louarn.simulation.modele.Position;

public abstract class Deplacement {


    public Deplacement() {
    }

    public abstract Position nextPosition(Position position);
}
