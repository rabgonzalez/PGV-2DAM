package ies.puerto;

import java.util.Random;
import java.util.Objects;

public class Cazador extends Thread{
    private String nombre;
    private final int PROBABILIDAD = 7;
    private Mapa mapa;

    public Cazador() {
    }

    public Cazador(String nombre) {
        this.nombre = nombre;
    }

    public Cazador(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
    }

    public Mapa getMapa() {
        return this.mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPROBABILIDAD() {
        return this.PROBABILIDAD;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cazador)) {
            return false;
        }
        Cazador cazador = (Cazador) o;
        return Objects.equals(nombre, cazador.nombre) && PROBABILIDAD == cazador.PROBABILIDAD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, PROBABILIDAD);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", PROBABILIDAD='" + getPROBABILIDAD() + "'" +
            "}";
    }

    public boolean matar(){
        Random random = new Random();
        int probabilidad = random.nextInt(10) + 1;

        if(probabilidad > PROBABILIDAD){
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        
    }
}
