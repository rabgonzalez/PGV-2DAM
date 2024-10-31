package ies.puerto.ejercicio5;

import java.io.*;
import java.net.*;

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
                File fichero = buscarFichero(message);
                if(fichero != null){
                    out.println(leerFichero(fichero));
                } else {
                    out.println("No se ha encontrado el fichero");
                }
            }
            clientSocket.close();
        }
    }

    public static File buscarFichero(String nombreFichero){
        String path = "src/main/java/ies/puerto/ejercicio5/server/";
        File directorio = new File(path);
        
        for (File file : directorio.listFiles()) {
            if(file.getName().equals(nombreFichero)){
                System.out.println("Se ha encontrado");
                return file;
            }
        }

        System.out.println("No se ha encontrado el fichero");
        return null;
    }

    public static String leerFichero(File file){
        FileInputStream fis = null;
        byte[] bytes = new byte[(int) file.length()];

        try {
            fis = new FileInputStream(file);

            fis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytesToHexString(bytes);
    }

    public static String bytesToHexString(byte[] bytes){
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}