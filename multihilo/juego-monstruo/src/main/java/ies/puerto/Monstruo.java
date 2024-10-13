package ies.puerto;

public class Monstruo extends Personaje implements Runnable{
    private boolean cazado = false;

    public boolean isCazado() {
        return this.cazado;
    }

    public void setCazado(boolean cazado) {
        this.cazado = cazado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Monstruo)) {
            return false;
        }
        Monstruo monstruo = (Monstruo) o;
        return cazado == monstruo.cazado;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
            " cazado='" + isCazado() + "'" +
            "}";
    }

    public Monstruo() {
    }

    public Monstruo(String nombre) {
        super(nombre);
    }

    public Monstruo(String nombre, Mapa mapa) {
        super(nombre, mapa);
    }

    @Override
    public void run() {
        int[] posicion = null;
        while(isCazado() == false){
            // Si en esa posición ya hay alguien, vuelve a moverse a una posición aleatoria
            posicion = getMapa().generarUbicacionAleatoria();
            getMapa().moverMonstruo(this, posicion);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
