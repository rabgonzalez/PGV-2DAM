package ies.puerto;
import java.util.Objects;

public class Monstruo {
    private String nombre;

    public Monstruo() {
    }

    public Monstruo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monstruo nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Monstruo)) {
            return false;
        }
        Monstruo monstruo = (Monstruo) o;
        return Objects.equals(nombre, monstruo.nombre);
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
}
