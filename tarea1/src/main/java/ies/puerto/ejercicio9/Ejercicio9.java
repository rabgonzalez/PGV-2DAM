package ies.puerto.ejercicio9;

import java.io.File;
import java.io.IOException;

public class Ejercicio9 {
    public Ejercicio9(){}

    public static void main(String[] args) {
        long tiempo = System.currentTimeMillis();
        ProcessBuilder pb = new ProcessBuilder("ping", "google.com");
        pb.redirectErrorStream(true);
        pb.redirectOutput(new File("tarea1/src/main/resources/ejercicio9.txt"));

        try{
            Process p = pb.start();
            while(true){
                if(System.currentTimeMillis() - tiempo > 6000){
                    p.destroy();
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
