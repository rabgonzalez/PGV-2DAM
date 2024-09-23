package ies.puerto.ejercicio4;

public class Ejercicio4 {
    public Ejercicio4() {}

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./tarea1/target/classes", "ies.puerto.ejercicio.ClaseB", "hola mundo!");
        
    }
}
