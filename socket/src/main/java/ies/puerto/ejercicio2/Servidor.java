package ies.puerto.ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Servidor escuchando en el puerto " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();  // Espera una conexión de cliente
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Recibido: " + message);
                out.println("Eco: " + message);  // Responde al cliente
            }
            clientSocket.close();
        }
    }
}