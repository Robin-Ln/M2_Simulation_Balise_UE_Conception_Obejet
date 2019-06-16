package fr.ubo.m2tiil.louarn.demo;

import fr.ubo.m2tiil.louarn.demo.vue.BaliseWorld;

public class simulation {
    public static void main(String[] args) {
        // Création de la simulation
        BaliseWorld baliseWorld = new BaliseWorld();
        // affichage de la simulation
        baliseWorld.open();

        /*
         * Cette boucle permet de deplacer les éléments (les balises et les satelites)
         * affichés dans la simulation.
         * Ici le delai entre deux déplacement est de 10 milli seconde
         */
        while (true) {

            baliseWorld.seDeplacer();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
