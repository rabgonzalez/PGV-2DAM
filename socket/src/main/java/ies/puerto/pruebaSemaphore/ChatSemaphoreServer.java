package ies.puerto.pruebaSemaphore;

import java.io.*;
import java.net.*;
import java.util.Set;
import java.util.concurrent.*;
import java.util.Objects;

public class ChatSemaphoreServer {
    private static final Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();
    public static final Semaphore semaphore = new Semaphore(2, true);

    public static void main(String[] args) {
        System.out.println("Servidor de chat iniciado...");
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                semaphore.acquire();
                Socket clientSocket = serverSocket.accept();

                System.out.println("Cliente conectado");
                System.out.println("Conexiones restantes: " + semaphore.availablePermits());

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler extends Thread {
        public Socket socket;
        public PrintWriter out;
        public BufferedReader in;

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof ChatSemaphoreServer)) {
                return false;
            }
            ChatSemaphoreServer css = (ChatSemaphoreServer) o;
            return Objects.equals(this, css);
        }

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
                    File fichero = buscarFichero(message);

                    if (fichero == null) {
                        out.println("No se ha encontrado el fichero: " + message);
                    } else {
                        byte[] bytes = leerFichero(fichero);
                        String hexFile = bytesToHexString(bytes);

                        out.println(message + "," + hexFile);
                        System.out.println("Fichero guardado como: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    clientWriters.remove(out);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("Un cliente se ha desconectado");
                    System.out.println("Conexiones restantes: " + semaphore.availablePermits());
                }
            }
        }
    }

    public static File buscarFichero(String nombreFichero) {
        String path = "src/main/java/ies/puerto/ejercicio5/server/";
        File directorio = new File(path);

        for (File file : directorio.listFiles()) {
            if (file.getName().equals(nombreFichero)) {
                System.out.println("Petición del fichero: " + nombreFichero);
                return file;
            }
        }

        System.out.println("No se ha encontrado el fichero: " + nombreFichero);
        return null;
    }

    public static byte[] leerFichero(File file) {
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
        return bytes;
    }

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}