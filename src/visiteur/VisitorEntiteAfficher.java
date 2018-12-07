package visiteur;

import modele.Balise;
import modele.Sattelite;
import vue.BaliseVue;
import vue.BaliseWorld;
import vue.SatteliteVue;


public class VisitorEntiteAfficher extends VisitorEntite {

    public VisitorEntiteAfficher(BaliseWorld baliseWorld) {
        super(baliseWorld);
    }

    @Override
    public void visite(Sattelite sattelite) {
        this.baliseWorld.contents().add(new SatteliteVue(sattelite));

    }

    @Override
    public void visite(Balise balise) {
        this.baliseWorld.contents().add(new BaliseVue(balise));
    }
}
