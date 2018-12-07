package modele;

import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import vue.BaliseWorld;

import java.util.ArrayList;
import java.util.List;

public class Modele {

    // Attributs

    private List<Entite> entites;

    // Constructeur

    public Modele(BaliseWorld baliseWorld) {
        this.entites = new ArrayList<>();
    }

    // Accesseurs

    public List<Entite> getEntites() {
        return entites;
    }

    public void setEntites(List<Entite> entites) {
        this.entites = entites;
    }



}
