package ies.puerto.ejercicio6;
import java.util.Objects;
import java.util.Random;

public class Tardis implements Runnable {
    private String nombre;
    private static final int DESTINO = 6;
    private int duracionViaje;
    private static boolean destinoConseguido = false;

    public Tardis() {
    }

    public Tardis(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionViaje() {
        return this.duracionViaje;
    }

    public void setDuracionViaje(int duracionViaje) {
        this.duracionViaje = duracionViaje;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tardis)) {
            return false;
        }
        Tardis tardis = (Tardis) o;
        return Objects.equals(nombre, tardis.nombre) && duracionViaje == tardis.duracionViaje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, duracionViaje);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", duracionViaje='" + getDuracionViaje() + "'" +
            "}";
    }

    @Override
    public void run() {
        while(!destinoConseguido){
            Random random = new Random();
            int destinoActual = random.nextInt(10) + 1;

            if(destinoActual == DESTINO && !destinoConseguido){
                destinoConseguido = true;
                System.out.println(nombre+" ha llegado al destino!");
                break;
            }
            System.out.println(nombre+" está viajando a la posición: " + destinoActual);
            
            duracionViaje = random.nextInt(5)*1000;
            try {
                Thread.sleep(duracionViaje);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
