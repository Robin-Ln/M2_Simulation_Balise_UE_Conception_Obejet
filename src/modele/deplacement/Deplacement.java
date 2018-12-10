package modele.deplacement;

import modele.Entite;
import modele.Position;

public abstract class Deplacement {

    private Integer vitesse;

    private Entite entite;

    public Deplacement(Integer vitesse, Entite entite) {
        this.vitesse = vitesse;
        this.entite = entite;
    }

    public abstract Position nextPosition(Position position);

    public Integer getVitesse() {
        return vitesse;
    }

    public void setVitesse(Integer vitesse) {
        this.vitesse = vitesse;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }
}
