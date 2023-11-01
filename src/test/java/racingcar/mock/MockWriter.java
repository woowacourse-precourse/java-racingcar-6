package racingcar.mock;

import racingcar.io.writer.Writer;

public class MockWriter implements Writer {
    private String output;

    @Override
    public void writeLine(String message) {
        output = message + "\n";
    }

    public String getOutput() {
        return output;
    }
}