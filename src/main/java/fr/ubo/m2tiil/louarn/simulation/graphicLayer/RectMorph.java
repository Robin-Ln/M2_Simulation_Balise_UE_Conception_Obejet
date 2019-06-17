
package fr.ubo.m2tiil.louarn.simulation.graphicLayer;

import java.awt.*;


public class RectMorph extends Morph {

    public RectMorph(Color color, Point pos, Dimension dim) {
        super(color, pos, dim);
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(color);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(c);
        super.draw(g);
    }

}
