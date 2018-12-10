package visiteur;

import modele.Balise;
import modele.Sattelite;
import vue.BaliseWorld;

public interface VisitorEntite {

    // Méthodes

    public abstract void visite (Balise balise);

    public abstract void visite (Sattelite sattelite);

}
