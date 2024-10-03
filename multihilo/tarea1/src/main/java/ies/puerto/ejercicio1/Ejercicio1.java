package ies.puerto.ejercicio1;

import java.util.Random;

public class Ejercicio1 implements Runnable{
    private String nombre;
    private int vida = 100;
    private static boolean ganador = false;

    public Ejercicio1(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while(vida > 0 && !ganador){
            Random random = new Random();
            int ataque = random.nextInt(10) + 1;
            vida -= ataque;
            System.out.println(nombre + " atacó y le restó " + ataque + " puntos de vida.");

            if(vida <= 0 && !ganador){
                ganador = true;
                System.out.println(nombre + " ha ganado!");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
