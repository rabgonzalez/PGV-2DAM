package ies.puerto.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ejercicio7 {
    public Ejercicio7(){}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("nano", "tarea1/src/main/java/ies/puerto/ejercicio7/prueba.txt");
        ProcessBuilder pb2 = new ProcessBuilder("cat", "tarea1/src/main/java/ies/puerto/ejercicio7/prueba.txt.save");

        try {
            Process process = pb.start();

            OutputStream output = process.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));

            bw.write("Esto es una prueba");
            bw.newLine();
            bw.flush();
            bw.close();

            System.out.println(process.waitFor());
            Process process2 = pb2.start();

            InputStream input = process2.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea+"\n");
            }
            br.close();

            System.out.println(process2.waitFor());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
