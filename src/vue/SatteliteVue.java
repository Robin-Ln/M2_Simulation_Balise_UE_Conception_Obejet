package vue;

import modele.Sattelite;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class SatteliteVue extends EntiteVue {

    public SatteliteVue(Sattelite sattelite) {
        super(sattelite);
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
        AffineTransform rotation1 = new AffineTransform();
        rotation1.setToRotation(Math.PI / 3);
        ((Graphics2D) g).setTransform(rotation1);
        g.setColor(c);
        super.draw(g);
    }
}
