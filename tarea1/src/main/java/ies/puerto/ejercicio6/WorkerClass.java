package ies.puerto.ejercicio6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerClass {
    public WorkerClass(){}

    public static void main(String[] args) {
        try {
            File file = new File("tarea1/src/main/resources/ejercicio6.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(args[0]);
            fw.close();
            System.out.println("Todo fue bien");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
