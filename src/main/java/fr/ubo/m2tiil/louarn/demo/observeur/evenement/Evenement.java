package fr.ubo.m2tiil.louarn.demo.observeur.evenement;

import fr.ubo.m2tiil.louarn.demo.observeur.Annonceur;
import fr.ubo.m2tiil.louarn.demo.observeur.Observeur;

public abstract class Evenement<Source extends Annonceur, Cible extends Observeur> {

    // Attributs

    private Source source;

    // Constructeur

    public Evenement(Source source) {
        this.source = source;
    }

    // Methodes

    abstract public void traitement(Cible cible);

    // Accesseur


    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
