package ies.puerto.tarea1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClaseB {

    public ClaseB() {
    }

    public static void main(String[] args) {
        try {
            File fichero = new File("tarea1/src/main/resources/tarea1.txt");
            if (fichero.exists()) {
                throw new IOException("El fichero ya existe");
            } else {
                fichero.createNewFile();
            }

            FileWriter escribirFichero = new FileWriter(fichero);
            escribirFichero.write("Hola mundo!");
            escribirFichero.close();
            System.out.println("Se ha escrito en el fichero");
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
            e.printStackTrace();
        }
    }
}