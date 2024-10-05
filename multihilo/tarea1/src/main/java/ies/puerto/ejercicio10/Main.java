package ies.puerto.ejercicio10;

public class Main {
    public static void main(String[] args) {
        Magia gandalf = new Magia("Gandalf", "Saruman");
        Magia saruman = new Magia("Saruman", "Gandalf");

        Thread hiloGandalf = new Thread(gandalf);
        Thread hiloSaruman = new Thread(saruman);

        hiloGandalf.start();
        hiloSaruman.start();

        try {
            hiloGandalf.join();
            hiloSaruman.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
