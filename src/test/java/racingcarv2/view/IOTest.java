package racingcarv2.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class IOTest {
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();
    private PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void afterTest() {
        System.setOut(standardOut);
        System.out.println(output());
        captor.reset();
        Console.close();
    }

    public InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public void setInGeneratedInputStream(InputStream inputStream) {
        System.setIn(inputStream);
    }

    public String output() {
        return captor.toString();
    }
}
