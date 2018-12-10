package observeur;

import java.awt.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable {


    private Map<Class<? extends Evenement>, List<Observeur>> observeursMap;

    public Observable() {

        this.observeursMap = new HashMap<>();
    }




    // V1
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





    // V1
    public void signal(Evenement evt) {
        List<Observeur> observeursList = this.observeursMap.get(evt.getClass());


        if (observeursList != null) {
            for (Observeur observeur : observeursList) {
                observeur.receive(evt);
            }
        }
    }
}
