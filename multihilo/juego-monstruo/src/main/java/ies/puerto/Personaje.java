package ies.puerto;
import java.util.Objects;

public class Personaje {
    private String nombre;
    private Mapa mapa;

    public Personaje() {
    }

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public Personaje(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mapa getMapa() {
        return this.mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Personaje nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Personaje mapa(Mapa mapa) {
        setMapa(mapa);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Personaje)) {
            return false;
        }
        Personaje personaje = (Personaje) o;
        return Objects.equals(nombre, personaje.nombre) && Objects.equals(mapa, personaje.mapa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, mapa);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", mapa='" + getMapa() + "'" +
            "}";
    }    
}
