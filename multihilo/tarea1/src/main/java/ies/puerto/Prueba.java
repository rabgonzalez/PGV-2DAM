package ies.puerto;

import java.util.Random;

public class Prueba implements Runnable {
    private String name;
    private int distance = 0;
    private static final int GOAL = 100;
    private static boolean ganador = false;

    @Override
    public void run() {
        while(distance < GOAL && !ganador) {
            Random random = new Random();
            int step = random.nextInt(10) + 1;
            distance += step;
            System.out.println(name+" avanzó "+step+" pasos");

            if(distance >= GOAL && !ganador) {
                ganador = true;
                System.out.println(name + " ha ganado!");
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread goku = new Thread(new Prueba("Goku"));
        Thread vegeta = new Thread(new Prueba("Vegeta"));
    
        goku.start();
        vegeta.start();
    }

    public Prueba(String name) {
        this.name = name;
    }
}