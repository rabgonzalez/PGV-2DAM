package ies.puerto.ejercicio8;
import java.util.Objects;
import java.util.Random;

public class Competicion implements Runnable {
    private String nombre;
    private int peso;
    private static final long DURACION = 5000;

    public Competicion() {
    }

    public Competicion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Competicion)) {
            return false;
        }
        Competicion competicion = (Competicion) o;
        return Objects.equals(nombre, competicion.nombre) && peso == competicion.peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, peso);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", peso='" + getPeso() + "'" +
            "}";
    }
    
    @Override
    public void run() {
        long tiempoInicial = System.currentTimeMillis();
        while(System.currentTimeMillis() - tiempoInicial < DURACION) {
            peso += 10;
            System.out.println(nombre+": "+peso+" kg");

            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3)*1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
