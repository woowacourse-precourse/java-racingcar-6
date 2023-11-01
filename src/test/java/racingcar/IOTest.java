package racingcar;

import java.io.ByteArrayInputStream;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IOTest {

    private ByteArrayOutputStream outputStreamCaptor;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    protected void clean() {
        Console.close();
    }

    protected void systemOut() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

}
