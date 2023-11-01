package racingcar.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.function.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import racingcar.utils.Console;

public abstract class MyTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString();
    }

    protected final <T> T input(final String arg, Supplier<T> supplier) {
        try {
            command(arg);
            return supplier.get();
        } finally {
            Console.close();
        }
    }

    private void command(final String arg) {
        final byte[] buf = arg.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
