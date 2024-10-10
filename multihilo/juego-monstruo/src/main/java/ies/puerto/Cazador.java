package ies.puerto;

import java.util.Random;
import java.util.Objects;

public class Cazador extends Personaje implements Runnable{
    public Cazador() {
    }

    public Cazador(String nombre) {
        super(nombre);
    }

    public Cazador(String nombre, Mapa mapa) {
        super(nombre, mapa);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void run() {
        Monstruo monstruo = new Monstruo("monstruo", getMapa());

        while(monstruo != null){
            int[] nuevaPosicion = getMapa().generarUbicacionAleatoria();
            getMapa().moverPersonaje(this, nuevaPosicion);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
