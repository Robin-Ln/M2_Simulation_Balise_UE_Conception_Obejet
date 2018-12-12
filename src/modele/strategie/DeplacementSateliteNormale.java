package modele.strategie;

import modele.Entite;
import modele.deplacement.VersLaDroite;

public class DeplacementSateliteNormale extends StrategieDeplacement {

    public DeplacementSateliteNormale(Entite entite, Integer vitesse) {
        super(entite, vitesse);

        VersLaDroite versLaDroite = new VersLaDroite(this);

        this.getNextDeplacements().put(versLaDroite, versLaDroite);

        this.setDeplacementEnCour(versLaDroite);

    }
}
