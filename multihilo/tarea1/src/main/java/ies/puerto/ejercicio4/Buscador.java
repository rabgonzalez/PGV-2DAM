package ies.puerto.ejercicio4;

import java.util.Random;

public class Buscador implements Runnable {
    private String equipo;
    private int intento;
    private static boolean encontrado = false;
    private static final int SUERTE = 10;

    public Buscador(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public void run() {
        while(intento != SUERTE && !encontrado){
            Random random = new Random();
            intento = random.nextInt(20);

            if(intento == SUERTE && !encontrado){
                encontrado = true;
                System.out.println("Quidditch encontrada por el equipo "+equipo+"!");
                break;
            }
            System.out.println(equipo+" no lo consigue... "+intento);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString(){
        return this.equipo;
    }
}