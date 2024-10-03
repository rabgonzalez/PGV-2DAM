package ies.puerto.ejercicio2;

public class Main {
    
    public static void main(String[] args) {
        Thread harry = new Thread(new Horrocruxes("Harry"));
        Thread hermione = new Thread(new Horrocruxes("Hermione"));
        Thread ron = new Thread(new Horrocruxes("Ron"));
    
        harry.start();
        hermione.start();
        ron.start();
    }
}
