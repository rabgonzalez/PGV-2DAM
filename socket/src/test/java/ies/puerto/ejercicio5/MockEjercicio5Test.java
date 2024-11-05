package ies.puerto.ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;

import static org.mockito.Mockito.*;

class MockEjercicio5Test {
    @Mock
    private Socket mockSocket;

    @Mock
    private BufferedReader mockBufferedReader;

    @Mock
    private PrintWriter mockPrintWriter;

    private ChatServer.ClientHandler clientHandler;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(mockSocket.getInputStream()).thenReturn(new ByteArrayInputStream("testFile.txt".getBytes()));
        when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

        clientHandler = new ChatServer.ClientHandler(mockSocket);

        clientHandler.in = mockBufferedReader;
        clientHandler.out = mockPrintWriter;
    }

    @Test
    void testbuscarFicheroOk() throws Exception {
        File mockFile = mock(File.class);
        when(ChatServer.buscarFichero("1.txt")).thenReturn(mockFile);

        when(ChatServer.leerFichero(mockFile)).thenReturn("Fichero encontrado".getBytes());
        when(mockBufferedReader.readLine()).thenReturn("1.txt").thenReturn(null);

        clientHandler.run();
        verify(mockPrintWriter).println("1.txt," + ChatServer.bytesToHexString("Fichero encontrado".getBytes()));
    }

    @Test
    void BuscarFicheroError() throws Exception {
        when(mockBufferedReader.readLine()).thenReturn("nonExistentFile.txt").thenReturn(null);

        clientHandler.run();
        verify(mockPrintWriter).println("No se ha encontrado el fichero: nonExistentFile.txt");
    }
}
