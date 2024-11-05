package ies.puerto.ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChatServerTest {
    ChatServer chat;

    @BeforeEach
    void beforeEach() {
        chat = new ChatServer();
    }

    @Test
    void bytesToHexString(){
        byte[] bytes = {69, 115, 116, 111, 32, 101, 115, 32, 112, 114, 117, 101, 98, 97, 32, 50};
        String resultado = chat.bytesToHexString(bytes);
        assertEquals("4573746F206573207072756562612032", resultado);
    }

    @Test
    void buscarFichero() {
        String nombreFichero = "1.txt";
        File resultado = chat.buscarFichero(nombreFichero);
        File file = new File("src/main/java/ies/puerto/ejercicio5/server/1.txt");
        assertEquals(file, resultado);
    }

    @Test
    void buscarFicheroNoEncontrado() {
        String nombreFichero = "ficheroNoEncontrado.txt";
        File resultado = chat.buscarFichero(nombreFichero);
        assertEquals(null, resultado);
    }

    @Test
    void leerFichero() {
        String nombreFichero = "1.txt";
        File file = chat.buscarFichero(nombreFichero);
        byte[] bytes = chat.leerFichero(file);
        String resultado = chat.bytesToHexString(bytes);
        assertEquals("6573746F206573207072756562612031", resultado);
    }
}
