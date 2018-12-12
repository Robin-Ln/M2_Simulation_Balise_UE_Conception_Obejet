package modele.strategie;

import modele.Entite;
import modele.deplacement.VersLaDroite;
import modele.deplacement.VersLeBas;
import modele.deplacement.VersLeHaut;

public class DeplacementBaliseNormale extends StrategieDeplacement {

    public DeplacementBaliseNormale(Entite entite, Integer vitesse) {
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
