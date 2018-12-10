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

    private Map<Class<? extends Evenement>, List<Enregistrement>> evenemens;

    public Observable() {
        this.evenemens = new HashMap<>();
    }


    // V2
    public void record(Class<? extends Evenement> evtClass, Observeur o, Method method) {
        List<Enregistrement> enregistrements = this.evenemens.get(evtClass);

        if (enregistrements == null) {
            enregistrements = new ArrayList<>();

            enregistrements.add(new Enregistrement(o, method));
            this.evenemens.put(evtClass, enregistrements);
            return;
        }

        enregistrements.add(new Enregistrement(o, method));
    }


    // V2
    public void signal(Evenement evt, List<Object> objects) {

        List<Enregistrement> enregistrements = this.evenemens.get(evt.getClass());

        if (enregistrements != null) {
            for (Enregistrement enregistrement : enregistrements) {
                try {
                    enregistrement.getMethod().invoke(enregistrement.getObserveur(), objects.toArray());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
