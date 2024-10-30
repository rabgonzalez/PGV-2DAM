package ies.puerto.ejercicio1;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 1234;
        Socket socket = new Socket(host, port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        
        while ((userInput = console.readLine()) != null) {
            out.println(userInput); 
            System.out.println("Respuesta del servidor: " + in.readLine());
        }

        socket.close();
    }
}
