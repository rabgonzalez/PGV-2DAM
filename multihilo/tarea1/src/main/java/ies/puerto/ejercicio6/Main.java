package ies.puerto.ejercicio6;

public class Main {
    public static void main(String[] args) {
        Tardis tardis1 = new Tardis("Tardis1");
        Tardis tardis2 = new Tardis("Tardis2");
        Tardis tardis3 = new Tardis("Tardis3");

        Thread hilo1 = new Thread(tardis1);
        Thread hilo2 = new Thread(tardis2);
        Thread hilo3 = new Thread(tardis3);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
