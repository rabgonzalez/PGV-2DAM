package ies.puerto.ejercicio5;

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
            String respuesta = in.readLine();
            if(!respuesta.startsWith("No")){
                guardarFichero(userInput, respuesta);
            }
            System.out.println(in.readLine()); 
        }

        socket.close();
    }

    public static void guardarFichero(String fichero, String contenido){
        FileWriter fw;
        try {
            fw = new FileWriter("src/main/java/ies/puerto/ejercicio5/client/"+fichero+".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public String leerFichero(String fichero){
        return "";
    }
}
