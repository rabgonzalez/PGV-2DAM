package ies.puerto.ejercicio7;
import java.util.Objects;
import java.util.Random;

public class Superheroe implements Runnable {
    private String nombre;
    private static final int CANTIDAD_AREAS = 10;
    private int areas;
    private static boolean ganador = false;

    public Superheroe(String nombre) {
        this.nombre = nombre;
        areas = 0;
    }

    public Superheroe() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAreas() {
        return this.areas;
    }

    public void setAreas(int areas) {
        this.areas = areas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Superheroe)) {
            return false;
        }
        Superheroe superheroe = (Superheroe) o;
        return Objects.equals(nombre, superheroe.nombre) && areas == superheroe.areas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, areas);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", areas='" + getAreas() + "'" +
            "}";
    }

    @Override
    public void run() {
        while(areas < CANTIDAD_AREAS && !ganador){
            areas++;

            if(areas == CANTIDAD_AREAS && !ganador){
                ganador = true;
                System.out.println(nombre+" ha salvado todas las áreas!");
                break;
            }
            System.out.println(nombre+" lleva "+areas+" áreas salvadas.");

            Random random = new Random();
            try {
                Thread.sleep((random.nextInt(5)*1000l));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
