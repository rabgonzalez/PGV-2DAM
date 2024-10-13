package ies.puerto;
import java.util.Objects;
import java.util.Random;

public class Mapa {
    private int size;
    private Personaje[][] ubicaciones;
    private final int PROBABILIDAD = 7;

    public Mapa() {
    }

    public Mapa(int size) {
        this.size = size;
        this.ubicaciones = new Personaje[size][size];
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Personaje[][] getUbicaciones() {
        return this.ubicaciones;
    }

    public void setUbicaciones(Personaje[][] ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public int getPROBABILIDAD(){
        return this.PROBABILIDAD;
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

    public int[] generarUbicacionAleatoria() {
        Random random = new Random();
        int x = random.nextInt(this.size);
        int y = random.nextInt(this.size);

        return new int[]{x,y};
    }

    public synchronized boolean matar(int[] posicion){
        Random random = new Random();
        int probabilidad = random.nextInt(10) + 1;

        if(probabilidad > getPROBABILIDAD()){
            return false;
        }
        getUbicaciones()[posicion[0]][posicion[1]] = null; 
        return true;
    }

    public synchronized void moverCazador(Cazador cazador, int[] nuevaPosicion){
        // Si el cazador ya tiene posicion, la eliminamos.
        if(cazador.getPosicion() != null){
            int[] posicionAnterior = cazador.getPosicion();
            getUbicaciones()[posicionAnterior[0]][posicionAnterior[1]] = null;
        }
        
        // Si en esa posición hay un monstruo y este muere, el cazador obtiene una kill.
        if(getUbicaciones()[nuevaPosicion[0]][nuevaPosicion[1]] instanceof Monstruo && matar(nuevaPosicion)){
            cazador.setKills(cazador.getKills()+1);
        }

        getUbicaciones()[nuevaPosicion[0]][nuevaPosicion[1]] = cazador;
        cazador.setPosicion(nuevaPosicion);
    }

    public void generarMonstruo(Monstruo monstruo){
        int[] spawn = null;

        // Si ya hay alguien en esa posicion, vuelve a generarse una nueva posicion.
        do {
            spawn = generarUbicacionAleatoria();
        } while(getUbicaciones()[spawn[0]][spawn[1]] instanceof Personaje);

        getUbicaciones()[spawn[0]][spawn[1]] = monstruo;
        monstruo.setPosicion(spawn);
    }
}
