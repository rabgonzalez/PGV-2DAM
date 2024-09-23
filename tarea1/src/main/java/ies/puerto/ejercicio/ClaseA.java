package ies.puerto.ejercicio;
import java.io.File;
import java.io.IOException;

public class ClaseA {

    public ClaseA() {
    }

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./tarea1/target/classes", "ies.puerto.ejercicio.ClaseB", "hola mundo!");
        pb.redirectErrorStream(true);
        pb.redirectOutput(new File("output.txt"));

        try{
            for(int i = 0; i < 10; i++){
                Process proceso = pb.start();
                int codigo = proceso.waitFor();
                System.out.println("El código es: "+codigo);
            }
        } catch(IOException | InterruptedException e){
            System.out.println("El proceso no se ha podido iniciar");
            e.printStackTrace();
        }
    }
}
