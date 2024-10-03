package ies.puerto.ejercicio4;

public class Main {
    public static void main(String[] args) {
        Thread buscador1 = new Thread(new Buscador("Equipo A"));
        Thread buscador2 = new Thread(new Buscador("Equipo B"));
        
        Cazador cazador1 = new Cazador("Cazador A", buscador1);
        Thread equipo1 = new Thread(cazador1);
        Cazador cazador2 = new Cazador("Cazador B", buscador2);
        Thread equipo2 = new Thread(cazador2);

        buscador1.start();
        buscador2.start();
        equipo1.start();
        equipo2.start();

        try {
            equipo1.join();
            equipo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cazador1.getEquipo()+": "+cazador1.getMarcador()+" puntos");
        System.out.println(cazador2.getEquipo()+": "+cazador2.getMarcador()+" puntos");
    }
}
