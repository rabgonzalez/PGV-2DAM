package ies.puerto.ejercicio3;

public class EnsamblarDroids implements Runnable{
    
    @Override
    public void run() {
        System.out.println("Hilo de ensamblaje trabajando...");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo de ensamblaje terminado");
    }
}
