package ies.puerto.ejercicio9;

public class Main {
    public static void main(String[] args) {
        Thread chewbacca = new Thread(new Chewbacca());
        Thread hanSolo = new Thread(new HanSolo(chewbacca));

        chewbacca.start();
        hanSolo.start();

        try {
            chewbacca.join();
            hanSolo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
