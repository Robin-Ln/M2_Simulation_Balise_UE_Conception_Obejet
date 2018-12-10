package vue;

import graphicLayer.Morph;
import modele.Balise;
import modele.Entite;
import modele.Sattelite;
import observeur.EntiteChange;
import observeur.Evenement;
import observeur.Observeur;
import observeur.SatteliteChange;

import java.awt.*;

public class EntiteVue extends Morph implements Observeur {

    public EntiteVue(Entite entite) {
        super(
                Color.WHITE,
                new Point(entite.getPosition().getX(), entite.getPosition().getY()),
                new Dimension(20, 20)
        );


        entite.record(EntiteChange.class, this);

    }

    @Override
    public void receive(Evenement evt) {
        Entite entite = (Entite) evt.source();
        Point point = new Point(entite.getPosition().getX(), entite.getPosition().getY());
        this.setPosition(point);
    }
}
