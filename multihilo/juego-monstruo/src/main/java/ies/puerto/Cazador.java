package ies.puerto;


public class Cazador extends Personaje implements Runnable{
    private int kills;

    public int getKills() {
        return this.kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cazador)) {
            return false;
        }
        Cazador cazador = (Cazador) o;
        return kills == cazador.kills;
    }

    @Override
    public String toString() {
        return "{" +
            " kills='" + getKills() + "'" +
            "}";
    }

    public Cazador() {
    }

    public Cazador(String nombre) {
        super(nombre);
    }

    public Cazador(String nombre, Mapa mapa) {
        super(nombre, mapa);
        this.kills = 0;
    }

    public Cazador(String nombre, Mapa mapa, int[] posicion) {
        super(nombre, mapa, posicion);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void run() {
        int[] nuevaPosicion = null;
        int contador = 0;

        while(this.getKills() < 3){
            nuevaPosicion = getMapa().generarUbicacionAleatoria();
            getMapa().moverCazador(this, nuevaPosicion);

            if(this.getKills() > contador){
                System.out.println(this.getNombre()+" ha capturado a "+this.getKills()+" monstruos!\n");
                contador = this.getKills();
            }

            if(getKills() == 3){
                System.out.println(this.getNombre()+" ha ganado!");
                break;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
