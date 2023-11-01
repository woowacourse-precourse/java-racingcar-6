package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestCommon {
    protected static final int MOVING_FORWARD = 4;
    protected static final int STOP = 3;
    protected static final String NEW_LINE = System.lineSeparator();

    private final PrintStream originalOutput = System.out;
    private OutputStream outputCaptor;

    protected void setInput(String inputValue) {
        System.setIn(new ByteArrayInputStream(inputValue.getBytes()));
    }

    protected void setInputs(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected String getOutput() {
        return outputCaptor.toString();
    }

    protected static String makeString(String... args) {
        StringBuilder output = new StringBuilder();
        for (String arg : args) {
            output.append(arg);
        }

        return output.toString();
    }

    @BeforeEach
    public void commonTestInit() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));
    }

    @AfterEach
    public void commonTestCleanUp() {
        System.setOut(originalOutput);
        Console.close();
    }
}
