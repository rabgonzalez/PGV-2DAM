package ies.puerto.ejercicio1;
import java.io.File;
import java.io.IOException;

public class Ejercicio1 {
    public Ejercicio1(){}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "google.com");
        pb.redirectErrorStream(true);
        pb.redirectOutput(new File("tarea1/src/main/resources/ejercicio1.txt"));

        try{
            Process p = pb.start();
            p.waitFor();
        } catch(IOException | InterruptedException e){
            System.out.println("El proceso no se ha podido iniciar");
            e.printStackTrace();
        }
    }
}
