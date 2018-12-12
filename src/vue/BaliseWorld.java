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

    public static final Integer vitesseSattelite = 2;


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

        // Les entité
        Balise balise = new Balise(modele,1950, BaliseWorld.height);
        Balise balise2 = new Balise(modele,1000, BaliseWorld.height);
        Balise balise3 = new Balise(modele, 500, BaliseWorld.height);
        Balise balise4 = new Balise(modele, 700, BaliseWorld.height);

        Sattelite sattelite = new Sattelite(modele,500, BaliseWorld.height - 100);
        Sattelite sattelite2 = new Sattelite(modele,0, BaliseWorld.height - 150);


        // Ajout des entite dans le modele (ajouter les satelites avant les balises )
        this.modele.getSattelites().add(sattelite);
        this.modele.getSattelites().add(sattelite2);

        this.modele.getBalisese().add(balise);
        this.modele.getBalisese().add(balise2);
        this.modele.getBalisese().add(balise3);
        this.modele.getBalisese().add(balise4);
    }


    public void seDeplacer() {
        this.modele.seDeplacer();
    }
}
