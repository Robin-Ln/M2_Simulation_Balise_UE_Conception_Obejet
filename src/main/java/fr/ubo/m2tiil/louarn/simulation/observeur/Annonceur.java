package fr.ubo.m2tiil.louarn.simulation.observeur;

import fr.ubo.m2tiil.louarn.simulation.observeur.evenement.Evenement;

import java.util.*;

public class Annonceur {

    private Map<Class<? extends Evenement>, List<Observeur>> evenemens;

    public Annonceur() {
        this.evenemens = Collections.synchronizedMap(new HashMap<>());
    }


    // V2
    public void record(Class<? extends Evenement> evtClass, Observeur o) {
        List<Observeur> observeurs = this.evenemens.get(evtClass);

        if (observeurs == null) {
            observeurs = Collections.synchronizedList(new ArrayList<>());
        }

        observeurs.add(o);
        this.evenemens.put(evtClass, observeurs);
    }


    // V2
    public void signal(Evenement evt) {

        List<Observeur> observeurs = this.evenemens.get(evt.getClass());

        if (observeurs != null) {
            Observeur[] arr = new Observeur[observeurs.size()];
            arr = observeurs.toArray(arr);
            for (Observeur observeur : arr) {
                evt.traitement(observeur);
            }
        }
    }

    public void unRecord(Class<? extends Evenement<?, ?>> eventClass, Observeur o) {
        List<Observeur> observeurs = evenemens.get(eventClass);

        if (observeurs == null) {
            return;
        }

        Iterator<Observeur> itor = observeurs.iterator();
        while (itor.hasNext()) {
            Observeur current = itor.next();
            if (o == current) itor.remove();
        }
        if (observeurs.isEmpty()) {
            evenemens.remove(eventClass);
        }
    }


}
