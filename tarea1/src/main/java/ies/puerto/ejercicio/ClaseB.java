package ies.puerto.ejercicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClaseB {

    public ClaseB() {
    }

    public static void main(String[] args) {
        try {
            File fichero = new File("tarea1/src/main/resources/tarea1.txt");
            if (!fichero.exists()) {
                fichero.createNewFile();
            }

            FileWriter escribirFichero = new FileWriter(fichero);
            escribirFichero.write(args[0]);
            escribirFichero.close();
            System.out.println("funciona");
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
            e.printStackTrace();
        }
    }
}