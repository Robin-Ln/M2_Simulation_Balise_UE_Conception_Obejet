package test;

import observeur.Annonceur;
import observeur.Observeur;
import observeur.evenement.Evenement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

class AnnouncerTest {


    @Test
    public void test() {
        // Creation des classe
        TestObserveur observeur = new TestObserveur();
        TestObservable observable = new TestObservable();

        // enregistrement
        observable.record(TestEvent.class, observeur);

        // signal
        TestEvent testEvent = new TestEvent(observable);
        observable.signal(testEvent);

        // signale reçus ?
        assertTrue(testEvent.log.size() == 1);
        assertTrue(testEvent.log.get(0).equals("class test.TestObservable -> class test.TestObserveur"));

    }
}

class TestObserveur implements Observeur {}

class TestObservable extends Annonceur {}


class TestEvent extends Evenement<TestObservable, TestObserveur> {

    List<String> log;


    public TestEvent(TestObservable testObservable) {
        super(testObservable);
        this.log = new ArrayList<>();
    }

    @Override
    public void traitement(TestObserveur testObserveur) {
        this.log.add(this.getSource().getClass() + " -> " + testObserveur.getClass());
    }
}
