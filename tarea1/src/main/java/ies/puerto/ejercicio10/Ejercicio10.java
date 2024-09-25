package ies.puerto.ejercicio10;

import java.io.IOException;
import java.io.File;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio10 {
    public Ejercicio10(){}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls");
        ProcessBuilder pb2 = new ProcessBuilder("grep");
        pb.redirectErrorStream(true);
        pb2.redirectErrorStream(true);

        try {
            Process p = pb.start();
            Process p2 = pb2.start();
            InputStream entrada = p.getInputStream();
            OutputStream salida = p.getOutputStream();
            p.waitFor();
            p2.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
