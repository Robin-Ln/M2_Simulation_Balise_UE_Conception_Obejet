package observeur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable {

    private Map<Class<? extends Evenement>, List<Observeur>> observeursMap;

    public Observable() {
        this.observeursMap = new HashMap<>();
    }

    public void record(Class<? extends Evenement> uneClass, Observeur o) {
        List<Observeur> observeursList = this.observeursMap.get(uneClass);


        if (observeursList == null) {
            observeursList = new ArrayList<>();
            observeursList.add(o);
            this.observeursMap.put(uneClass, observeursList);
            return;
        }

        observeursList.add(o);
    }

    public void signal(Evenement evt) {
        List<Observeur> observeursList = this.observeursMap.get(evt.getClass());


        if (observeursList != null) {
            for (Observeur observeur : observeursList) {
                observeur.receive(evt);
            }
        }
    }
}
