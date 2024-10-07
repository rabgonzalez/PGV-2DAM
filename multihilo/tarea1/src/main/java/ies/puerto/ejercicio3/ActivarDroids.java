package ies.puerto.ejercicio3;

public class ActivarDroids implements Runnable {
    private Thread hiloEnsamblaje;

    public ActivarDroids(Thread hiloEnsamblaje) {
        this.hiloEnsamblaje = hiloEnsamblaje;
    }

    @Override
    public void run() {
        try{
            hiloEnsamblaje.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hilo de activación trabajando...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo de activación terminado");
    }
}