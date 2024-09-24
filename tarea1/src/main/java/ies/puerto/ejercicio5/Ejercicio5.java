package ies.puerto.ejercicio5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejercicio5 {
    public Ejercicio5(){}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls", "-e");
        pb.redirectErrorStream(true);
        pb.redirectError(new File("tarea1/src/main/resources/ejercicio5.txt"));

        try {
            Process process = pb.start();
            InputStream error = process.getErrorStream();
            for(int i = 0; i < error.available(); i++){
                System.out.println(""+error.read());
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
