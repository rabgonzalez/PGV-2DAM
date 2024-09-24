package ies.puerto.ejercicio2;
import java.io.IOException;
import java.io.File;

public class Ejercicio2 {
    public Ejercicio2(){}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls");
        ProcessBuilder pb2 = new ProcessBuilder("echo", "hola");
        pb.redirectErrorStream(true);
        pb2.redirectErrorStream(true);

        pb.redirectOutput(new File("tarea1/src/main/resources/ejercicio2.xt"));
        pb2.redirectOutput(new File("tarea1/src/main/resources/ejercicio2_2.txt"));

        try {
            Process p = pb.start();
            Process p2 = pb2.start();

            int codigo = p.waitFor();
            int codigo2 = p2.waitFor();

            System.out.println("Codigo de salida: "+codigo);
            System.out.println("Codigo de salida: "+codigo2);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
