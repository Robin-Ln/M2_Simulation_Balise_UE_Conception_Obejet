package fr.ubo.m2tiil.louarn.simulation.modele.strategie;

import fr.ubo.m2tiil.louarn.simulation.modele.Entite;
import fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement.VersLaDroite;

public class StrategieDeplacementSateliteNormale extends StrategieDeplacement {

    public StrategieDeplacementSateliteNormale(Entite entite, Integer vitesse) {
        super(entite, vitesse);

        VersLaDroite versLaDroite = new VersLaDroite(this);

        this.getNextDeplacements().put(versLaDroite, versLaDroite);

        this.setDeplacementEnCour(versLaDroite);

    }
}
