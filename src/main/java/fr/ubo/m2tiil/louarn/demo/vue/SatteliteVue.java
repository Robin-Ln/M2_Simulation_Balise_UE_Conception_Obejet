package fr.ubo.m2tiil.louarn.demo.vue;

import fr.ubo.m2tiil.louarn.demo.graphicLayer.World;
import fr.ubo.m2tiil.louarn.demo.modele.Sattelite;

import java.awt.*;

public class SatteliteVue extends EntiteVue {

    public SatteliteVue(Sattelite sattelite, World world) {
        super(sattelite, world);
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(color);
        g.fillRect(bounds.x - (bounds.width / 2), bounds.y - (bounds.height / 2), bounds.width, bounds.height);
        g.setColor(Color.RED);
        g.fillRect(bounds.x - (bounds.width), bounds.y - (bounds.height / 10), bounds.width * 2, bounds.height / 10);
        g.setColor(Color.BLUE);
        g.fillRect(bounds.x - (bounds.width) * 3, bounds.y - (bounds.height / 5), bounds.width * 2, bounds.height / 3);
        g.fillRect(bounds.x + (bounds.width), bounds.y - (bounds.height / 5), bounds.width * 2, bounds.height / 3);
        g.setColor(c);
        super.draw(g);
    }
}
