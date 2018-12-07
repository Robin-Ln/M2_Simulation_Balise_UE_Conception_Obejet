package vue;

import graphicLayer.World;
import modele.*;
import modele.deplacement.Deplacement;
import modele.deplacement.VersLaDroite;
import observeur.SatteliteChange;

import java.awt.*;

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
        Balise balise = new Balise();
        Position position = new Position(BaliseWorld.width + 200, BaliseWorld.height);
        Deplacement deplacement = new VersLaDroite(10);
        balise.setPosition(position);
        balise.setDeplacement(deplacement);

        // Satelite
        Sattelite sattelite = new Sattelite();
        Position position2 = new Position(BaliseWorld.width - 200, BaliseWorld.height-100);
        Deplacement deplacement2 = new VersLaDroite(5);
        sattelite.setPosition(position2);
        sattelite.setDeplacement(deplacement2);


        // abonement de la balise pour le satelite
        sattelite.record(SatteliteChange.class, balise);

        // les Vues
        BaliseVue baliseVue = new BaliseVue(balise);
        SatteliteVue satteliteVue = new SatteliteVue(sattelite);

        this.contents().add(baliseVue);
        this.contents().add(satteliteVue);


        baliseVue.setWorld(this);
        satteliteVue.setWorld(this);


        this.modele.getEntites().add(balise);
        this.modele.getEntites().add(sattelite);
    }


    public void seDeplacer() {
        for (Entite entite : this.modele.getEntites()){
            entite.seDeplacer();
        }
    }
}
