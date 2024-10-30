package ies.puerto.ejercicio3;

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
                String[] numeros = message.split(" ");
                if(numeros.length > 2 || numeros.length < 2){
                    out.println("Error: Debe introducir dos números separados por un espacio.");
                    continue;
                }

                int num1 = Integer.parseInt(numeros[0]);
                int num2 = Integer.parseInt(numeros[1]);
                int suma = num1 + num2;

                System.out.println("Recibido: " + message);
                out.println("Eco: " + suma);  // Responde al cliente
            }
            clientSocket.close();
        }
    }
}