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
                System.out.println("Recibido: " + message);

                if(suma(message) == -1){
                    out.println("Debes introducir exactamente 2 números positivos");
                    return; 
                }
                out.println("Eco: " + suma(message));  // Responde al cliente
            }
            clientSocket.close();
        }
    }

    public static int suma(String message){
        String[] numeros = message.split(" ");
        if(numeros.length > 2 || numeros.length < 2){
            return -1;
        }

        int num1 = Integer.parseInt(numeros[0]);
        int num2 = Integer.parseInt(numeros[1]);
        return (num1+num2);
    }
}