package vue;

import modele.Balise;

import java.awt.*;

public class BaliseVue extends EntiteVue {

    public BaliseVue(Balise balise) {
        super(balise);
    }

    public void draw(Graphics g) {
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
}