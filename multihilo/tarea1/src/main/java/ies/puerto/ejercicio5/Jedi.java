package ies.puerto.ejercicio5;

import java.util.Objects;
import java.util.Random;

public class Jedi implements Runnable {
    private String nombre;
    private int jugada;
    private static boolean pistaEncontrada = false;
    private static final int PISTA = 2;

    public Jedi() {
    }

    public Jedi(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getJugada() {
        return this.jugada;
    }

    public void setJugada(int jugada) {
        this.jugada = jugada;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Jedi)) {
            return false;
        }
        Jedi jedi = (Jedi) o;
        return Objects.equals(nombre, jedi.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            "}";
    }

    @Override
    public void run() {
        while(!pistaEncontrada && jugada != PISTA){
            Random random = new Random();
            jugada = random.nextInt(10) + 1;

            if(jugada == PISTA && !pistaEncontrada){
                System.out.println(nombre + " ha encontrado la pista!");
                pistaEncontrada = true;
                break;
            }
            System.out.println(nombre + " sigue buscando la pista: " + jugada);
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
