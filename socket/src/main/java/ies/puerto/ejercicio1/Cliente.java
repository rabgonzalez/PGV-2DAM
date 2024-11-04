package ies.puerto.ejercicio1;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 1234;
        Socket socket = new Socket(host, port); //La conexión al servidor

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //Manda lo que introduzcas al servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Lee lo que le llega del servidor
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); //Lee lo que escribes por consola

        String userInput;
        while ((userInput = console.readLine()) != null) {
            out.println(userInput); //Manda lo que escribes por consola al servidor
            System.out.println("Respuesta del servidor: " + in.readLine()); //Muestra lo que llega del servidor
        }

        socket.close();
    }
}
