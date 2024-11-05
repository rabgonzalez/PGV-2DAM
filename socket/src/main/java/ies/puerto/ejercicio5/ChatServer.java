package ies.puerto.ejercicio5;

import java.io.*;
import java.net.*;
import java.util.Set;
import java.util.concurrent.*;

public class ChatServer {
    private static final Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {
        System.out.println("Servidor de chat iniciado...");
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);

                String message;
                while ((message = in.readLine()) != null) {
                    out.println(message+","+buscarFichero(message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientWriters.remove(out);
            }
        }
    }

    public static String buscarFichero(String nombreFichero) {
        String path = "src/main/java/ies/puerto/ejercicio5/server/";
        File directorio = new File(path);

        for (File file : directorio.listFiles()) {
            if (file.getName().equals(nombreFichero)) {
                System.out.println("Petición del fichero: "+nombreFichero);
                return leerFichero(file);
            }
        }

        System.out.println("No se ha encontrado el fichero: "+nombreFichero);
        return "";
    }

    public static String leerFichero(File file) {
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

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}