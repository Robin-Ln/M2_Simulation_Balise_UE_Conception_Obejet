package observeur;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable {

    // private Map<Class<? extends Evenement>, Map<Method, List<Observeur>>> evenementMap;

    private Map<Class<? extends Evenement>, List<Observeur>> observeursMap;

    public Observable() {
        // this.evenementMap = new HashMap<>();
        this.observeursMap = new HashMap<>();
    }


    /*
    public void performRecord(Class<? extends Evenement> evtClass, Observeur o, Method method) {
        Map<Method, List<Observeur>> methodMap = this.evenementMap.get(evtClass);

        if (methodMap == null) {
            methodMap = new HashMap<>();

            List<Observeur> observeurList = new ArrayList<>();
            observeurList.add(o);

            methodMap.put(method, observeurList);
            return;
        }

        List<Observeur> observeurList = methodMap.get(method);
        if (observeurList == null) {

            observeurList = new ArrayList<>();
            observeurList.add(o);
            return;
        }

        observeurList.add(o);


    }*/


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

    /*
    public void signalPerform(Evenement evt, Method method, List<Object> objects) {
        Map<Method, List<Observeur>> methodMap = this.evenementMap.get(evt.getClass());

        if (methodMap != null) {

            List<Observeur> observeurList = methodMap.get(method);

            for (Observeur observeur : observeurList) {
                try {
                    method.invoke(objects);
                } catch ( Exception e) {
                    System.out.println("exeption invoke");
                }
            }
        }
    }*/


    public void signal(Evenement evt) {
        List<Observeur> observeursList = this.observeursMap.get(evt.getClass());


        if (observeursList != null) {
            for (Observeur observeur : observeursList) {
                observeur.receive(evt);
            }
        }
    }

}
