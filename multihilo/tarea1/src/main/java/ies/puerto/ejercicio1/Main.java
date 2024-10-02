package ies.puerto.ejercicio1;

public class Main {
    
    public static void main(String[] args) {
        Thread pikachu = new Thread(new Ejercicio1("pikachu"));
        Thread charmander = new Thread(new Ejercicio1("charmander"));

        pikachu.start();
        charmander.start();
    }
}
