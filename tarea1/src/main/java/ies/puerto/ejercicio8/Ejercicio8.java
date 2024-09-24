package ies.puerto.ejercicio8;

import java.io.File;
import java.io.IOException;

public class Ejercicio8 {
    public Ejercicio8(){}

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "2", "google.com");
        pb.redirectErrorStream(true);
        System.out.println("Se ha creado correctamente");
        pb.redirectOutput(new File("tarea1/src/main/resources/ejercicio8.txt"));
        
        try {
            Process p = pb.start();
            p.waitFor();
            long endTime = System.nanoTime();
            System.out.println("El proceso a tardado: "+(endTime-startTime)+" nanosegundos");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
