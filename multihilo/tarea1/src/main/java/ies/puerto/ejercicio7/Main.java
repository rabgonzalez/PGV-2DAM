package ies.puerto.ejercicio7;

public class Main {
    public static void main(String[] args) {
        Superheroe superman = new Superheroe("Superman");
        Superheroe batman = new Superheroe("Batman");

        Thread hiloSuperman = new Thread(superman);
        Thread hiloBatman = new Thread(batman);

        hiloSuperman.start();
        hiloBatman.start();

        try {
            hiloSuperman.join();
            hiloBatman.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
