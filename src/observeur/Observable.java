package observeur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable {

    private Map<Class<? extends Evenement>, List<Observeur>> evenemens;

    public Observable() {
        this.evenemens = new HashMap<>();
    }


    // V2
    public void record(Class<? extends Evenement> evtClass, Observeur o) {
        List<Observeur> observeurs = this.evenemens.get(evtClass);

        if (observeurs == null) {
            observeurs = new ArrayList<>();

            observeurs.add(o);
            this.evenemens.put(evtClass, observeurs);
            return;
        }

        observeurs.add(o);
    }


    // V2
    public void signal(Evenement evt) {

        List<Observeur> observeurs = this.evenemens.get(evt.getClass());

        if (observeurs != null) {
            for (Observeur observeur : observeurs) {
                evt.traitement(observeur);
            }
        }
    }


}
