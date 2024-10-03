package ies.puerto.ejercicio4;
import java.util.Objects;

public class Cazador implements Runnable{
    private String nombre;
    private int marcador;
    private Thread buscador;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMarcador() {
        return this.marcador;
    }

    public void setMarcador(int marcador) {
        this.marcador = marcador;
    }

    public Thread getBuscador() {
        return this.buscador;
    }

    public void setBuscador(Thread buscador) {
        this.buscador = buscador;
    }

    public Cazador(String nombre, Thread buscador) {
        this.nombre = nombre;
        this.buscador = buscador;
    }

    public Cazador() {
    }

    public Cazador(String nombre, int marcador, Thread buscador) {
        this.nombre = nombre;
        this.marcador = marcador;
        this.buscador = buscador;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cazador)) {
            return false;
        }
        Cazador cazador = (Cazador) o;
        return Objects.equals(nombre, cazador.nombre) && marcador == cazador.marcador && Objects.equals(buscador, cazador.buscador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, marcador, buscador);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", marcador='" + getMarcador() + "'" +
            ", buscador='" + getBuscador() + "'" +
            "}";
    }

    @Override
    public void run() {
        while(buscador.isAlive()){
            marcador++;
            System.out.println(nombre+" ha recogido 1 punto para el "+buscador.toString());

            if(buscador.isInterrupted()){
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
