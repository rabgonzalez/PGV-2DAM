package ies.puerto.ejercicio5;

public class Main {
    
    public static void main(String[] args) {
        Jedi jedi = new Jedi("jedi1");
        Jedi jedi2 = new Jedi("jedi2");
        Thread hilo = new Thread(jedi);
        Thread hilo2 = new Thread(jedi2);

        hilo.start();
        hilo2.start();

        try {
            hilo.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
