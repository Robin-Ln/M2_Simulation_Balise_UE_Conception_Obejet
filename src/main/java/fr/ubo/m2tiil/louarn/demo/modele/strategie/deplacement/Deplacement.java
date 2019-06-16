package fr.ubo.m2tiil.louarn.demo.modele.strategie.deplacement;

import fr.ubo.m2tiil.louarn.demo.modele.Position;

public abstract class Deplacement {


    public Deplacement() {
    }

    public abstract Position nextPosition(Position position);
}
