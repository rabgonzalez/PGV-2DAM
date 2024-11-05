package ies.puerto.ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
    Cliente cliente;

    @BeforeEach
    void beforeEach() {
        cliente = new Cliente();
    }

    @Test
    void hexToString(){
        String hex = "48656C6C6F20576F726C64";
        String resultado = cliente.hexToString(hex);
        assertEquals("Hello World", resultado);
    }

    @Test
    void guardarFicheroOk(){
        String nombreFichero = "clienteTest.txt";
        String contenido = "Este es un test del método: guardarFichero()";
        boolean resultado = cliente.guardarFichero(nombreFichero, contenido);
        assertEquals(true, resultado);
    }
}
