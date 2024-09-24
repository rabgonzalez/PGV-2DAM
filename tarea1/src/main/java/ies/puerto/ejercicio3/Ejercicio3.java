package ies.puerto.ejercicio3;
import java.io.IOException;
import java.io.File;

public class Ejercicio3 {
    public Ejercicio3() {}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls");
        pb.redirectErrorStream(true);
        pb.redirectOutput(new File("tarea1/src/main/resources/ejercicio3.txt"));

        try {
            Process p = pb.start();
            int codigo = p.waitFor();
            System.out.println("Código de salida: "+codigo);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
