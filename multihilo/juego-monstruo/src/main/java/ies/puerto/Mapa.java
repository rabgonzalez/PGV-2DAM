package ies.puerto;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Mapa {
    private int size;
    private Map<String, int[][]> ubicaciones;

    public Mapa() {
    }

    public Mapa(int size) {
        this.size = size;
    }

    public Mapa(int size, Map<String,int[][]> ubicaciones) {
        this.size = size;
        this.ubicaciones = ubicaciones;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String,int[][]> getUbicaciones() {
        return this.ubicaciones;
    }

    public void setUbicaciones(Map<String,int[][]> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mapa)) {
            return false;
        }
        Mapa mapa = (Mapa) o;
        return size == mapa.size && Objects.equals(ubicaciones, mapa.ubicaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, ubicaciones);
    }

    @Override
    public String toString() {
        return "{" +
            " size='" + getSize() + "'" +
            ", ubicaciones='" + getUbicaciones() + "'" +
            "}";
    }

    public String generarUbicacionAleatoria() {
        Random random = new Random();
        int x = random.nextInt(this.size-1);
        int y = random.nextInt(this.size-1);

        return x+","+y;
    }

    public synchronized int[][] moverCazador(Cazador cazador, String nuevaPosicion){
        String[] posicion = nuevaPosicion.split(",");
        int[][] ubicacion = new int[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])];

        ubicaciones.put(cazador.getName(), ubicacion);
        return ubicacion;
    }

    public synchronized void generarMonstruo(Monstruo monstruo, String nuevaPosicion){
        String[] posicion = nuevaPosicion.split(",");
        int[][] ubicacion = new int[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])];

        ubicaciones.put(monstruo.getNombre(), ubicacion);
    }
}
