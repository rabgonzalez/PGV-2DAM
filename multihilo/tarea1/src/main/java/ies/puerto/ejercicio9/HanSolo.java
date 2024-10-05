package ies.puerto.ejercicio9;
import java.util.Objects;

public class HanSolo implements Runnable{
    private long velocidad = 200000l;
    private Thread chewbacca;

    public HanSolo() {
    }

    public HanSolo(Thread chewbacca) {
        this.chewbacca = chewbacca;
    }

    public Thread getChewbacca() {
        return this.chewbacca;
    }

    public void setChewbacca(Thread chewbacca) {
        this.chewbacca = chewbacca;
    }
   
    @Override
    public void run() {
        while(chewbacca.isAlive()) {
            velocidad += 10;
            System.out.println("HanSolo: Voy a "+velocidad+" km/s.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!chewbacca.isAlive()){
                System.out.println("El sistema ha fallado, nave destruida.");
                break;
            }
        }
    }
}
