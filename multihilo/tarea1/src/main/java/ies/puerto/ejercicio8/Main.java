package ies.puerto.ejercicio8;

public class Main {
    public static void main(String[] args) {
        Competicion thor = new Competicion("Thor");
        Competicion hulk = new Competicion("Hulk");

        Thread hiloThor = new Thread(thor);
        Thread hiloHulk = new Thread(hulk);

        System.out.println("THOR VS HULK");
        System.out.println("¿QUIÉN LEVANTARÁ MÁS PESO?");
        System.out.println("--------------------------");

        hiloThor.start();
        hiloHulk.start();

        try {
            hiloThor.join();
            hiloHulk.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------");
        if(thor.getPeso() > hulk.getPeso()) {
            System.out.println("THOR HA GANADO CON "+thor.getPeso()+" KG");
        } else if(thor.getPeso() < hulk.getPeso()) {
            System.out.println("HULK HA GANADO CON "+thor.getPeso()+" KG");
        } else {
            System.out.println("EMPATE EN "+thor.getPeso()+" KG");
        }
    }
}
