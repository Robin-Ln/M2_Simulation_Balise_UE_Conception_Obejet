package fr.ubo.m2tiil.louarn.demo;

import fr.ubo.m2tiil.louarn.demo.observeur.Annonceur;
import fr.ubo.m2tiil.louarn.demo.observeur.Observeur;
import fr.ubo.m2tiil.louarn.demo.observeur.evenement.Evenement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(testEvent.log.get(0).equals("class fr.ubo.m2tiil.louarn.demo.TestObservable -> class fr.ubo.m2tiil.louarn.demo.TestObserveur"));

    }
}

class TestObserveur implements Observeur {}

class TestObservable extends Annonceur {}


class TestEvent extends Evenement<TestObservable, TestObserveur> {

    List<String> log;


    public TestEvent(TestObservable testObservable) {
        super(testObservable);
        this.log = new ArrayList<String>();
    }

    @Override
    public void traitement(TestObserveur testObserveur) {
        this.log.add(this.getSource().getClass() + " -> " + testObserveur.getClass());
    }
}