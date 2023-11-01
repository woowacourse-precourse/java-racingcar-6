package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class IOTest {

    private final PrintStream standardOut = System.out;
    private final OutputStream captor = new ByteArrayOutputStream();

    @BeforeEach
    protected final void initTestIOEnvironment() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void clearTestIOEnvironment() {
        Console.close();
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
