package ies.puerto;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(3);  
        Cazador cazador1 = new Cazador("Cazador 1", mapa);
        Thread thread1 = new Thread(cazador1);    
        thread1.start();        
    }
}