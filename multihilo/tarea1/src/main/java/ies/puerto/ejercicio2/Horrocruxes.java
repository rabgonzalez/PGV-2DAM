package ies.puerto.ejercicio2;

import java.util.Random;

public class Horrocruxes implements Runnable {
    private String personaje;
    private static final int HORROCRUXES = 8;
    private static boolean ganador = false;
    private int jugada;

    public Horrocruxes(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public void run(){
        while(jugada != HORROCRUXES && !ganador){
            Random random = new Random();
            jugada = random.nextInt(10);

            if(jugada == HORROCRUXES && !ganador){
                ganador = true;
                System.out.println(personaje+" ha encontrado los Horrocruxes!");
                break;
            }
            System.out.println(personaje+" ha fallado en la búsqueda");
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}