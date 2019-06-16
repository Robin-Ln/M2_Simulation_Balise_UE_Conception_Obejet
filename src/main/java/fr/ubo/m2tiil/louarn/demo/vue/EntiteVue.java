package fr.ubo.m2tiil.louarn.demo.vue;

import fr.ubo.m2tiil.louarn.demo.graphicLayer.Morph;
import fr.ubo.m2tiil.louarn.demo.graphicLayer.World;
import fr.ubo.m2tiil.louarn.demo.modele.Entite;
import fr.ubo.m2tiil.louarn.demo.observeur.evenement.EntiteChange;
import fr.ubo.m2tiil.louarn.demo.observeur.Observeur;

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
