package ies.puerto;

import java.util.Objects;

public class Cazador extends Personaje implements Runnable{
    public static int kills = 0;

    public Cazador() {
    }

    public Cazador(String nombre) {
        super(nombre);
    }

    public Cazador(String nombre, Mapa mapa) {
        super(nombre, mapa);
    }

    public Cazador(String nombre, Mapa mapa, int[] posicion) {
        super(nombre, mapa, posicion);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cazador)) {
            return false;
        }
        Cazador cazador = (Cazador) o;
        return Objects.equals(this, cazador);
    }

    @Override
    public String toString() {
        return "{" +
            "}";
    }

    @Override
    public void run() {
        int[] nuevaPosicion = null;
        int contador = 0;

        while(kills < 2){
            nuevaPosicion = getMapa().generarUbicacionAleatoria();
            getMapa().moverCazador(this, nuevaPosicion);

            if(kills > contador){
                contador = kills;
            }

            if(kills == 2){
                System.out.println("Todos los monstruos han sido capturados, Fin de la partida.");
                break;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
