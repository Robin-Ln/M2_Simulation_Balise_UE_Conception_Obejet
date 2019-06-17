package fr.ubo.m2tiil.louarn.simulation.modele.strategie;

import fr.ubo.m2tiil.louarn.simulation.modele.Entite;
import fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement.VersLaDroite;
import fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement.VersLeBas;
import fr.ubo.m2tiil.louarn.simulation.modele.strategie.deplacement.VersLeHaut;

public class StrategieDeplacementBaliseNormale extends StrategieDeplacement {

    public StrategieDeplacementBaliseNormale(Entite entite, Integer vitesse) {
        super(entite, vitesse);

        VersLaDroite versLaDroite = new VersLaDroite(this);
        VersLeHaut versLeHaut = new VersLeHaut(this);
        VersLeBas versLeBas = new VersLeBas(this);

        this.getNextDeplacements().put(versLeHaut, versLaDroite);
        this.getNextDeplacements().put(versLaDroite, versLeBas);
        this.getNextDeplacements().put(versLeBas, versLeHaut);

        this.setDeplacementEnCour(versLeHaut);

    }
}
