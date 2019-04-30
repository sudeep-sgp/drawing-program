package com.cs.ag;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class AppTest {

    @BeforeEach
    void setUp() {}

    @AfterEach
    void tearDown() {}

    @Test
    void processControllerTest() {
        String canvasCommand = "C 20 4";
        byte[] command = canvasCommand.getBytes();
        InputStream input = new ByteArrayInputStream(command);
        Scanner scanner = new Scanner(input);
        // App.processController(canvasCommand);

    }
}
