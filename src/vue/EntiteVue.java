package vue;

import graphicLayer.Morph;
import modele.Entite;
import observeur.evenement.EntiteChange;
import observeur.Observeur;

import java.awt.*;

public class EntiteVue extends Morph implements Observeur {

    public EntiteVue(Entite entite) {
        super(
                Color.WHITE,
                new Point(entite.getPosition().getX(), entite.getPosition().getY()),
                new Dimension(20, 20)
        );

        try {
            entite.record(EntiteChange.class, this);
        } catch (Exception e) {
            System.out.println("exeption getMethod");
        }
    }
}
