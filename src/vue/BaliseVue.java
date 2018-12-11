package vue;

import graphicLayer.World;
import modele.Balise;

import java.awt.*;

public class BaliseVue extends EntiteVue {

    public BaliseVue(Balise balise, World world) {
        super(balise,world);
    }

    public void draw(Graphics g) {
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
}