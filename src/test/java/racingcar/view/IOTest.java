package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class IOTest {

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    private void allocateSystemOut() {
        outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    protected void allocateSystemIn(String input) {
        byte[] bytesInput = input.getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytesInput);
        System.setIn(inputStream);
    }

    protected String getSystemOut() {
        return outputStreamCaptor.toString();
    }
}
