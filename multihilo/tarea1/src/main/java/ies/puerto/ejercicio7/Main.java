package ies.puerto.ejercicio7;

public class Main {
    public static void main(String[] args) {
        Superheroe superman = new Superheroe("Superman");
        Superheroe batman = new Superheroe("Batman");

        Thread hiloSuperman = new Thread(superman);
        Thread hiloBatman = new Thread(batman);

        System.out.println("SUPERMAN VS BATMAN");
        System.out.println("EL PRIMERO QUE SALVE 10 AREAS, GANA");
        System.out.println("-------------------------------");
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
