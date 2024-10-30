package ies.puerto.ejercicio5;

import java.io.*;
import java.net.*;
import java.nio.file.Files;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Servidor escuchando en el puerto " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();  // Espera una conexión de cliente
            System.out.println("Inserta el nombre de un fichero: ");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                if (buscarFichero(message).equals("")) {
                    out.println("Fichero no encontrado.");
                } else {
                    out.println(buscarFichero(message));
                }
            }
            clientSocket.close();
        }
    }

    public static String buscarFichero(String nombreFichero){
        String path = "src/main/java/ies/puerto/ejercicio5/server/";
        File directorio = new File(path);
        
        File[] ficheros = directorio.listFiles();
        
        for (File fichero : ficheros) {
            if(fichero.getName().equals(nombreFichero+".txt")){
                try {
                    byte[] bytes = Files.readAllBytes(directorio.toPath());
                    return obtenerBytes(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static String obtenerBytes(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(b); 
        }
        return sb.toString();
    }
}