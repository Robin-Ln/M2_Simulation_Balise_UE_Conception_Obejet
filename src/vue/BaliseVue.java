package vue;

import graphicLayer.World;
import modele.Balise;

import java.awt.*;

public class BaliseVue extends EntiteVue {

    public BaliseVue(Balise balise, World world) {
        super(balise,world);
    }

    public void draw(Graphics g) {
        Color c = null;

        if(this.getPosition().y == BaliseWorld.height){
            c = Color.DARK_GRAY;
        } else {
            c = Color.RED;
        }

        g.setColor(c);
        g.fillOval(bounds.x-(bounds.height/2),bounds.y-(bounds.width/2),bounds.height,bounds.width);
        g.setColor(c);
        super.draw(g);
    }
}