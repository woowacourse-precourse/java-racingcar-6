package racingcar.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import racingcar.io.writer.Writer;

public class MockWriter implements Writer {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Override
    public void writeLine(String message) {
        new PrintStream(output).println(message);
    }

    public String getOutput() {
        return output.toString();
    }
}