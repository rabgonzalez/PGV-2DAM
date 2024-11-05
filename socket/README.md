# Ejercicios con Sockets
## Rubén Abreu Gonzalez

### Índice
- [Ejercicios con Sockets](#ejercicios-con-sockets)
  - [Rubén Abreu Gonzalez](#rubén-abreu-gonzalez)
    - [Índice](#índice)
    - [Ejercicio 1](#ejercicio-1)
    - [Ejercicio 2](#ejercicio-2)
    - [Ejercicio 3](#ejercicio-3)
    - [Ejercicio 4](#ejercicio-4)
    - [Ejercicio 5](#ejercicio-5)
      - [Métodos](#métodos)

### Ejercicio 1
El ejericio consiste en tener 2 sockets (Socket-cliente y Socket-servidor) en los que el cliente manda mensajes al servidor y este devuelve los mismos mensajes.

- **Servidor**
```java
        public class Servidor {
        public static void main(String[] args) throws IOException {
            int port = 1234;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor escuchando en el puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();  // Espera una conexión de cliente
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //Manda información al cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //Recibe información del cliente

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Recibido: " + message); //Obtiene mensaje del cliente
                    out.println("Eco: " + message);  //Responde al cliente
                }

                clientSocket.close();
            }
        }
    }
```

- **Cliente**
```java
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
```

### Ejercicio 2
Muy parecido al ejercicio anterior, pero si el cliente ingresa por consola la frase "salir", su socket se cerrará instantáneamente finalizando su conexión con el servidor

- **Cambios:**
```java
    while ((userInput = console.readLine()) != null) {
        if(userInput.equals("salir")){
            socket.close();
            break;
        }
        out.println(userInput); 
        System.out.println("Respuesta del servidor: " + in.readLine());
    }
```

### Ejercicio 3
Consiste en manejar la salida del cliente en el servidor. En este ejercicio, el servidor recibira 2 números separados por espacio del cliente, y este, por medio de una función, obtendrá la suma de los números y se la mostrará al cliente.

- **Función de sumar:**
```java
    public static int suma(String message){
        String[] numeros = message.split(" ");
        if(numeros.length > 2 || numeros.length < 2){
            return -1;
        }

        int num1 = Integer.parseInt(numeros[0]);
        int num2 = Integer.parseInt(numeros[1]);
        return (num1+num2);
    }
```

### Ejercicio 4
Este ejercicio trabaja con threads para gestionar la conexión de varios usuarios y mostrar cada mensaje a todos, simulando un chat en línea

- **ChatServer**
```java
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
                        System.out.println("Mensaje recibido: " + message);
                        sendMessageToAllClients(message);
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

            private void sendMessageToAllClients(String message) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
```

### Ejercicio 5
El ejercicio final consiste en la gestión de ficheros. El servidor tiene una serie de ficheros en la carpeta *server*, si un cliente ingresa el nombre de un fichero, el servidor lo busca, lo pasa a hexadecimal (más fácil de manipular que el binario, aunque un poco más pesado) y se lo manda al usuario.
Por último, el usuario vuelve a convertir en texto el hexadecimal del servidor y guarda el fichero en la carpeta *client*.

#### Métodos
- **Servidor**
  - buscarFichero()
    ```java
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
    ```

  - leerFichero()
    ```java
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
    ```

  -  bytesToHexString()
    ```java
        public static String bytesToHexString(byte[] bytes) {
            StringBuilder sb = new StringBuilder();

            for (byte b : bytes) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString();
        }
    ```

- **Cliente**
  - hexToString()
    ```java
        public static String hexToString(String hex){
            StringBuilder sb = new StringBuilder();

            if(hex.length() == 0){
                return "";
            }

            for (int i = 0; i < hex.length(); i += 2) { //Saltamos de 2 en 2 para coger el inicio de cada valor entero
                String hexNum = hex.substring(i, (i+2)); //Cogemos 2 numeros, que serán un valor entero
                int num = Integer.parseInt(hexNum, 16); //Pasamos el valor hexadecimal a int (del 1 al 16)
                sb.append((char) num); //Convertimos el numero en una letra y la añadimos al string final
            }
            return sb.toString();
        }
    ```

  - guardarFichero()
    ```java
        public static boolean guardarFichero(String fichero, String contenido){
            FileWriter fw;
            try {
                fw = new FileWriter("src/main/java/ies/puerto/ejercicio5/client/"+fichero);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
                
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    ```
