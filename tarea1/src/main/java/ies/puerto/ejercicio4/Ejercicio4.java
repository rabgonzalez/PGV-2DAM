package ies.puerto.ejercicio4;

import java.io.File;
import java.io.IOException;

public class Ejercicio4 {
    public Ejercicio4() {}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("echo", "Hola mundo! este es el Ejercicio 4");
        pb.redirectErrorStream(true);
        pb.redirectOutput(new File("tarea1/src/main/resources/ejercicio4.txt"));

        try {
            Process proceso = pb.start();
            int codigo = proceso.waitFor();
            System.out.println("El código es : "+codigo);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
