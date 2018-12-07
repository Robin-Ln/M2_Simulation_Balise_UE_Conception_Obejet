package visiteur;

import modele.Balise;
import modele.Sattelite;
import vue.BaliseWorld;

public abstract class VisitorEntite {

    // Attributs

    protected BaliseWorld baliseWorld;

    // Constructeur

    public VisitorEntite(BaliseWorld baliseWorld) {
        this.baliseWorld = baliseWorld;
    }


    // Méthodes

    public abstract void visite (Balise balise);

    public abstract void visite (Sattelite sattelite);

    // Accesseurs


    public BaliseWorld getBaliseWorld() {
        return baliseWorld;
    }

    public void setBaliseWorld(BaliseWorld baliseWorld) {
        this.baliseWorld = baliseWorld;
    }
}
