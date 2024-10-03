package ies.puerto.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Thread hiloEnsamblaje = new Thread(new EnsamblarDroids());
        Thread hiloActivacion = new Thread(new ActivarDroids(hiloEnsamblaje));

        hiloEnsamblaje.start();
        hiloActivacion.start();
    }
}
