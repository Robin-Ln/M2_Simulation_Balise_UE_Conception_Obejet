package vue;

import graphicLayer.World;
import modele.Balise;
import modele.Modele;
import modele.Sattelite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

        this.creerTerrain();

        this.setPreferredSize(new Dimension(BaliseWorld.width, BaliseWorld.height * 2));

        this.modele = new Modele(this);


        // --------------

        // keylistener
        this.setKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()){
                    case 'b':
                        ajouterBalise();
                        break;
                    case 's':
                        ajouterSatelite();
                        break;
                    case 'c':
                        clearSimulation();
                    default:
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void creerTerrain(){
        this.ciel = new CielVue(new Point(0, 0), new Dimension(BaliseWorld.width, BaliseWorld.height));
        this.contents().add(this.ciel);

        this.merVue = new MerVue(new Point(0, BaliseWorld.height), new Dimension(BaliseWorld.width, BaliseWorld.height));
        this.contents().add(this.merVue);
    }

    private void ajouterSatelite(){
        Sattelite sattelite = new Sattelite(modele,500, BaliseWorld.height - 100);
        this.modele.getSattelites().add(sattelite);
    }

    private void ajouterBalise(){
        Balise balise = new Balise(modele,1950, BaliseWorld.height);
        this.modele.getBalisese().add(balise);
    }

    private void clearSimulation(){
        clear();
        this.modele.getSattelites().clear();
        this.modele.getBalisese().clear();
        this.creerTerrain();
    }


    public void seDeplacer() {
        this.modele.seDeplacer();
    }

}
