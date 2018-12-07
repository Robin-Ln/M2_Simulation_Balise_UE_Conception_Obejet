package demo;

import vue.BaliseWorld;

public class simulation {
    public static void main(String[] args) {
        BaliseWorld baliseWorld = new BaliseWorld();
        baliseWorld.open();
        while (true) {

            baliseWorld.seDeplacer();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
