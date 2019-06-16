package fr.ubo.m2tiil.louarn.demo.vue;

import fr.ubo.m2tiil.louarn.demo.graphicLayer.World;
import fr.ubo.m2tiil.louarn.demo.modele.Balise;

import java.awt.*;

public class BaliseVue extends EntiteVue {

    public BaliseVue(Balise balise, World world) {
        super(balise,world);
    }

    public void draw(Graphics g) {
        Color c = null;

        if(this.getPosition().y == BaliseWorld.height){
            c = this.color;
        } else {
            c = Color.RED;
        }

        g.setColor(c);
        g.fillOval(bounds.x-(bounds.height/2),bounds.y-(bounds.width/2),bounds.height,bounds.width);
        g.setColor(c);
        super.draw(g);
    }
}
