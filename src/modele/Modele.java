package modele;

import observeur.evenement.SatteliteChange;
import vue.BaliseWorld;

import java.util.ArrayList;
import java.util.List;

public class Modele {

    // Attributs

    private List<Balise> balisese;
    private List<Sattelite> sattelites;

    // Constructeur

    public Modele(BaliseWorld baliseWorld) {
        this.balisese = new ArrayList<>();
        this.sattelites = new ArrayList<>();
    }

    // Methodes

    public void seDeplacer() {
        for (Sattelite sattelite : this.sattelites) {
            sattelite.seDeplacer();
        }
        for (Balise balise : this.balisese) {
            balise.seDeplacer();
        }
    }

    // Accesseurs


    public List<Balise> getBalisese() {
        return balisese;
    }

    public void setBalisese(List<Balise> balisese) {
        this.balisese = balisese;
    }

    public List<Sattelite> getSattelites() {
        return sattelites;
    }

    public void setSattelites(List<Sattelite> sattelites) {
        this.sattelites = sattelites;
    }
}
