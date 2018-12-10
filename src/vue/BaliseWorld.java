package vue;

import graphicLayer.World;
import modele.*;
import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import observeur.SatteliteChange;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BaliseWorld extends World {

    // Attributs

    public static final Integer width = 1000;

    public static final Integer height = 250;

    private CielVue ciel;

    private MerVue merVue;

    private Modele modele;

    // Constructeur

    public BaliseWorld() {
        super("Simulation");

        this.ciel = new CielVue(new Point(0, 0), new Dimension(BaliseWorld.width, BaliseWorld.height));
        this.contents().add(this.ciel);

        this.merVue = new MerVue(new Point(0, BaliseWorld.height), new Dimension(BaliseWorld.width, BaliseWorld.height));
        this.contents().add(this.merVue);

        this.setPreferredSize(new Dimension(BaliseWorld.width, BaliseWorld.height * 2));

        this.modele = new Modele(this);


        // --------------

        // Balise
        Balise balise = new Balise(BaliseWorld.width + 200, BaliseWorld.height, 10);

        // Satelite
        Sattelite sattelite = new Sattelite(BaliseWorld.width - 200, BaliseWorld.height - 100, 5);

        // abonement de la balise pour le satelite
        try {
            sattelite.record(SatteliteChange.class, balise, Balise.class.getMethod("sendData", Sattelite.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // les Vues
        BaliseVue baliseVue = new BaliseVue(balise);
        SatteliteVue satteliteVue = new SatteliteVue(sattelite);


        // Ajout pour le repaint
        this.contents().add(baliseVue);
        this.contents().add(satteliteVue);


        baliseVue.setWorld(this);
        satteliteVue.setWorld(this);


        this.modele.getEntites().add(balise);
        this.modele.getEntites().add(sattelite);
    }


    public void seDeplacer() {
        for (Entite entite : this.modele.getEntites()) {
            entite.seDeplacer();
        }
    }
}
