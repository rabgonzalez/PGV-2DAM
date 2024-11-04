package ies.puerto.ejercicio5;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 12345;
        Socket socket = new Socket(host, port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = console.readLine()) != null) {
            out.println(userInput);
            String[] response = in.readLine().split(",");
            guardarFichero(response[0], hexToString(response[1]));
        }
        socket.close();
    }

    public static String hexToString(String hex){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hex.length(); i += 2) { //Saltamos de 2 en 2 para coger el inicio de cada valor entero
            String hexNum = hex.substring(i, (i+2)); //Cogemos 2 numeros, que serán un valor entero
            int num = Integer.parseInt(hexNum, 16); //Pasamos el valor hexadecimal a int (del 1 al 16)
            sb.append((char) num); //Convertimos el numero en una letra y la añadimos al string final
        }
        return sb.toString();
    }

    public static void guardarFichero(String fichero, String contenido){
        FileWriter fw;
        try {
            fw = new FileWriter("src/main/java/ies/puerto/ejercicio5/client/"+fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}