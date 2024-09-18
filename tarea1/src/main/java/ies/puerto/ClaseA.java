package ies.puerto;
import java.io.IOException;

public class ClaseA {

    public ClaseA() {
    }

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", ".", "ies.puerto.claseB.java");

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
