package fr.ubo.m2tiil.louarn.simulation.vue;

import fr.ubo.m2tiil.louarn.simulation.graphicLayer.Morph;
import fr.ubo.m2tiil.louarn.simulation.graphicLayer.World;
import fr.ubo.m2tiil.louarn.simulation.modele.Entite;
import fr.ubo.m2tiil.louarn.simulation.observeur.Observeur;
import fr.ubo.m2tiil.louarn.simulation.observeur.evenement.EntiteChange;

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
