package modele.deplacement;

import modele.Position;

public abstract class Deplacement {

    private Integer vitesse;

    public Deplacement(Integer vitesse) {
        this.vitesse = vitesse;
    }

    public abstract Position nextPosition(Position position);

    public Integer getVitesse() {
        return vitesse;
    }

    public void setVitesse(Integer vitesse) {
        this.vitesse = vitesse;
    }
}
