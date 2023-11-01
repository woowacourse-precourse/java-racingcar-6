package utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputUtil {
    private static ByteArrayOutputStream outputStreamCaptor;

    public static void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    public static String getOutputString() {
        return outputStreamCaptor.toString().trim();
    }
}
