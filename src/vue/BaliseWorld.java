package vue;

import graphicLayer.World;
import modele.Balise;
import modele.Entite;
import modele.Modele;
import modele.Sattelite;
import observeur.evenement.SatteliteChange;

import java.awt.*;

public class BaliseWorld extends World {

    // Attributs

    public static final Integer width = 1000;

    public static final Integer height = 250;

    public static final Integer vitesseBalise = 1;

    public static final Integer vitesseSattelite = 5;


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
        Balise balise = new Balise(BaliseWorld.width + 195, BaliseWorld.height);
        Balise balise2 = new Balise(BaliseWorld.width + 100, BaliseWorld.height);
        Balise balise3 = new Balise(BaliseWorld.width + 50, BaliseWorld.height);
        Balise balise4 = new Balise(BaliseWorld.width + 0, BaliseWorld.height);

        // Satelite
        Sattelite sattelite = new Sattelite(BaliseWorld.width + 200, BaliseWorld.height - 100);

        // abonement de la balise pour le satelite
        sattelite.record(SatteliteChange.class, balise);
        sattelite.record(SatteliteChange.class, balise2);
        sattelite.record(SatteliteChange.class, balise3);
        sattelite.record(SatteliteChange.class, balise4);

        // les Vues
        BaliseVue baliseVue = new BaliseVue(balise);
        BaliseVue baliseVue2 = new BaliseVue(balise2);
        BaliseVue baliseVue3 = new BaliseVue(balise3);
        BaliseVue baliseVue4 = new BaliseVue(balise4);

        SatteliteVue satteliteVue = new SatteliteVue(sattelite);


        // Ajout pour le repaint
        this.contents().add(baliseVue);
        this.contents().add(baliseVue2);
        this.contents().add(baliseVue3);
        this.contents().add(baliseVue4);
        this.contents().add(satteliteVue);


        baliseVue.setWorld(this);
        baliseVue2.setWorld(this);
        baliseVue3.setWorld(this);
        baliseVue4.setWorld(this);
        satteliteVue.setWorld(this);


        this.modele.getEntites().add(balise);
        this.modele.getEntites().add(balise2);
        this.modele.getEntites().add(balise3);
        this.modele.getEntites().add(balise4);
        this.modele.getEntites().add(sattelite);
    }


    public void seDeplacer() {
        for (Entite entite : this.modele.getEntites()) {
            entite.seDeplacer();
        }
    }
}
