package ies.puerto.ejercicio9;

import java.util.Random;

public class Chewbacca implements Runnable{
    private int escudosRestantes = 100;

    public int getEscudosRestantes() {
        return escudosRestantes;
    }

    @Override
    public void run() {
        while(escudosRestantes > 0) {
            Random random = new Random();
            System.out.println("Chewbacca: Escudo restante: "+escudosRestantes);
            escudosRestantes -= random.nextInt(20)+1;

            if(escudosRestantes <= 0){
                break;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
