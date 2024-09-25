package ies.puerto.ejercicio10;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ejercicio10 {
    public Ejercicio10(){}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls");
        //ProcessBuilder pb2 = new ProcessBuilder("grep", "tarea1");

        try {
            Process process = pb.start();
            //Process process2 = pb2.start();

            OutputStream output = process.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
            
            bw.write("tarea10");
            bw.newLine();
            bw.flush();
            bw.close();

            InputStream input = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();
            //System.out.println(process2.waitFor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
