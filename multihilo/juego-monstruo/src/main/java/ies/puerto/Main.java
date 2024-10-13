package ies.puerto;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Mapa mapa = new Mapa(4); 

        Cazador cazador1 = new Cazador("1", mapa);
        Cazador cazador2 = new Cazador("2", mapa);
        Monstruo monstruo1 = new Monstruo("M", mapa);
        Monstruo monstruo2 = new Monstruo("M", mapa);

        Thread thread1 = new Thread(cazador1);   
        Thread thread2 = new Thread(cazador2); 
        Thread thread3 = new Thread(monstruo1);
        Thread thread4 = new Thread(monstruo2);

        thread3.start();
        thread4.start();
        thread1.start(); 
        thread2.start();        

        while(thread1.isAlive() && thread2.isAlive()){
            pintarMapa(mapa);
        }
    }

    public static void pintarMapa(Mapa mapa) throws InterruptedException{
        Personaje[][] ubicaciones = mapa.getUbicaciones();
        for(int i = 0; i < ubicaciones.length; i++){
            for(int j = 0; j <= ubicaciones.length-1; j++){
                if(ubicaciones[i][j] == null){
                    System.out.print(". ");
                } else {
                    System.out.print(ubicaciones[i][j].getNombre() + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        Thread.sleep(1500);
    }
}