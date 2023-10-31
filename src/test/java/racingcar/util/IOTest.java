package racingcar.util;


import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class IOTest {
    private PrintStream standardOut;
    private OutputStream captor;


    @BeforeEach
    protected final void init() {
        Console.close();
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected void input(final String... input) {
        final byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final String output(boolean leftTrim, boolean rightTrim) {

        String captorStr = captor.toString().replaceAll("\\r", "");

        if (leftTrim && rightTrim) {
            return captorStr.trim();
        }
        if (leftTrim) {
            return captorStr.replaceAll("^\\s+", "");
        }
        if (rightTrim) {
            return captorStr.replaceAll("\\s$+", "");
        }
        return captorStr;
    }

}
