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

    public void ajouterBalise(Balise balise) {
        this.balisese.add(balise);
        for (Sattelite sattelite : this.sattelites) {
            sattelite.record(SatteliteChange.class, balise);
        }
    }

    public void ajouterSattelite(Sattelite sattelite) {
        this.sattelites.add(sattelite);
    }

    public void seDeplacer() {
        for (Sattelite sattelite : this.sattelites) {
            sattelite.seDeplacer();
        }
        for (Balise balise : this.balisese) {
            balise.seDeplacer();
        }
    }

    // Accesseurs


}
