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
        Balise balise = new Balise(1950, BaliseWorld.height);
        Balise balise2 = new Balise(1000, BaliseWorld.height);
        Balise balise3 = new Balise( 500, BaliseWorld.height);
        Balise balise4 = new Balise( 700, BaliseWorld.height);

        Sattelite sattelite = new Sattelite(500, BaliseWorld.height - 100);
        Sattelite sattelite2 = new Sattelite(0, BaliseWorld.height - 150);


        // les Vues
        new BaliseVue(balise, this);
        new BaliseVue(balise2, this);
        new BaliseVue(balise3, this);
        new BaliseVue(balise4, this);

        new SatteliteVue(sattelite, this);
        new SatteliteVue(sattelite2, this);


        // Ajout des entite dans le modele (ajouter les satelites avant les balises )
        this.modele.ajouterSattelite(sattelite);
        this.modele.ajouterSattelite(sattelite2);

        this.modele.ajouterBalise(balise);
        this.modele.ajouterBalise(balise2);
        this.modele.ajouterBalise(balise3);
        this.modele.ajouterBalise(balise4);
    }


    public void seDeplacer() {
        this.modele.seDeplacer();
    }
}
