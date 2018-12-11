package vue;

import graphicLayer.World;
import modele.Balise;

import java.awt.*;

public class BaliseVue extends EntiteVue {

    public BaliseVue(Balise balise, World world) {
        super(balise,world);
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(bounds.x-(bounds.height/2),bounds.y-(bounds.width/2),bounds.height,bounds.width);
        g.setColor(c);
        super.draw(g);
    }
}