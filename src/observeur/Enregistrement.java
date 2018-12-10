package observeur;

import java.lang.reflect.Method;

public class Enregistrement {

    // Attributs

    private Observeur observeur;

    private Method method;

    // constructeur

    public Enregistrement(Observeur observeur, Method method) {
        this.observeur = observeur;
        this.method = method;
    }

    // methodes

    @Override
    public String toString() {
        return "Enregistrement{" +
                "observeur=" + observeur +
                ", method=" + method +
                '}';
    }


    // Accesseurs

    public Observeur getObserveur() {
        return observeur;
    }

    public void setObserveur(Observeur observeur) {
        this.observeur = observeur;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
