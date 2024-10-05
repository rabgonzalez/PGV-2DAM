package ies.puerto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import ies.puerto.ejercicio10.Magia;

public class Ejercicio10Test {

    @Test
    public void TestBattallaMagia() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Magia gandalf = new Magia("Gandalf", "Saruman");
        Magia saruman = new Magia("Saruman", "Gandalf");

        Thread hiloGandalf = new Thread(gandalf);
        Thread hiloSaruman = new Thread(saruman);

        hiloGandalf.start();
        hiloSaruman.start();

        hiloGandalf.join();
        hiloSaruman.join();

        String output = outContent.toString();
        assertTrue(output.contains("Gandalf ha ganado") || output.contains("Saruman ha ganado"));
    }    
}
