package fr.ubo.m2tiil.louarn.simulation.modele.strategie;

import fr.ubo.m2tiil.louarn.simulation.modele.Entite;
import fr.ubo.m2tiil.louarn.simulation.modele.Position;
import fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement.Deplacement;

import java.util.HashMap;
import java.util.Map;

public abstract class StrategieDeplacement {

    // Attributs

    private Map<Deplacement, Deplacement> nextDeplacements;

    private Deplacement deplacementEnCour;

    private Entite entite;

    private Integer vitesse;

    // Constructeur

    public StrategieDeplacement(Entite entite, Integer vitesse) {
        this.nextDeplacements = new HashMap<Deplacement, Deplacement>();
        this.entite = entite;
        this.vitesse = vitesse;
    }

    public void nextDeplacement() {
        Deplacement nextDeplacement = this.nextDeplacements.get(this.deplacementEnCour);

        if (nextDeplacement == null) {
            throw new RuntimeException("Il n'y a pas de deplacement suivant pour le deplacement : " + this.deplacementEnCour);
        }

        this.deplacementEnCour = nextDeplacement;
    }

    public void seDeplacer() {
        Position position = deplacementEnCour.nextPosition(this.entite.getPosition());
        this.entite.setPosition(position);
    }

    // Accesserus

    public Map<Deplacement, Deplacement> getNextDeplacements() {
        return nextDeplacements;
    }

    public void setNextDeplacements(Map<Deplacement, Deplacement> nextDeplacements) {
        this.nextDeplacements = nextDeplacements;
    }

    public Deplacement getDeplacementEnCour() {
        return deplacementEnCour;
    }

    public void setDeplacementEnCour(Deplacement deplacementEnCour) {
        this.deplacementEnCour = deplacementEnCour;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }

    public Integer getVitesse() {
        return vitesse;
    }

    public void setVitesse(Integer vitesse) {
        this.vitesse = vitesse;
    }
}
