package vue;

import graphicLayer.Morph;
import graphicLayer.World;
import modele.Entite;
import observeur.evenement.EntiteChange;
import observeur.Observeur;

import java.awt.*;

public class EntiteVue extends Morph implements Observeur {

    public EntiteVue(Entite entite, World world) {
        super(
                Color.WHITE,
                new Point(entite.getPosition().getX(), entite.getPosition().getY()),
                new Dimension(10, 30)
        );

        this.setWorld(world);
        world.contents().add(this);

        entite.record(EntiteChange.class, this);

    }
}
