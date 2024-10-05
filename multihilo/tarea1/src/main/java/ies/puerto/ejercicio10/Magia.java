package ies.puerto.ejercicio10;
import java.util.Objects;
import java.util.Random;

public class Magia implements Runnable{
    private String nombre;
    private int energia = 100;
    private static boolean muerto = false;
    private String contrincante;

    public Magia() {
    }

    public Magia(String nombre, String contrincante) {
        this.nombre = nombre;
        this.contrincante = contrincante;
    }

    public String getContrincante() {
        return this.contrincante;
    }

    public void setContrincante(String contrincante) {
        this.contrincante = contrincante;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Magia)) {
            return false;
        }
        Magia magia = (Magia) o;
        return Objects.equals(nombre, magia.nombre) && energia == magia.energia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, energia);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", energia='" + getEnergia() + "'" +
            "}";
    }

    @Override
    public void run() {
        while(energia > 0 && !muerto) {
            Random random = new Random();
            energia -= random.nextInt(30)+1;

            if(energia <= 0 && !muerto) {
                muerto = true;
                System.out.println("La magia de "+nombre+" ha muerto. "+contrincante+" ha ganado.");
                break;
            }
            System.out.println("A "+contrincante+" le quedan "+energia+" puntos de energía.");

            try {
                Thread.sleep(random.nextInt(3)*1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
