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
                Socket clientSocket = serverSocket.accept();

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
```

- **Cliente**
```java
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
```

### Ejercicio 2


### Ejercicio 3


### Ejercicio 4


### Ejercicio 5


