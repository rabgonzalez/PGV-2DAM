package ies.puerto.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Ejercicio3Test {
   
    Servidor servidor;

    @BeforeEach
    void beforeEach() {
        servidor = new Servidor();
    }
    
    @Test
    void SumaTestOk() {
        int resultado = servidor.suma("5 10");
        assertEquals(15, resultado);
    }

    @Test
    void SumaTestError() {
        int resultado = servidor.suma("5");
        assertEquals(-1, resultado);

        int resultado2 = servidor.suma("5 10 15");
        assertEquals(-1, resultado2);
    }
}
