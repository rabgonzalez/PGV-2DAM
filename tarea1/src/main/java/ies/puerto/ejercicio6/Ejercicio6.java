package ies.puerto.ejercicio6;

import java.io.IOException;

public class Ejercicio6 {
    public Ejercicio6(){}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./tarea1/target/classes", "ies.puerto.ejercicio6.Ejercicio6", "Adios mundo!");

        try {
            for(int i = 0; i < 5; i++){
                Process p = pb.start();
                int codigo = p.waitFor();
                System.out.println("Codigo: "+codigo);
            }
            System.out.println("Fin del programa");
        } catch (IOException | InterruptedException e) {
            System.out.println("El proceso no se ha podido iniciar");

            e.printStackTrace();
        }
    }
}
