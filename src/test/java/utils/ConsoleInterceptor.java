package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleInterceptor {
    static PrintStream standardOutputStream = System.out;
    static InputStream standardInputStream = System.in;
    static OutputStream testOutputStream;

    public static void setupConsoleIntercept() {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    public static void restoreConsoleIntercept() {
        System.setOut(standardOutputStream);
        System.setIn(standardInputStream);
    }

    public static InputStream getInputStream(String input) {
        final byte[] buf = input.getBytes();
        return new ByteArrayInputStream(buf);
    }

    public static String getPrintedString() {
        String input = testOutputStream.toString();
        return input;
    }

    public static void printToConsole(String input) {
        standardOutputStream.println(input);
    }
}
