package racingcar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class BaseTest {
    OutputStream setIO() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        return out;
    }

    OutputStream setIO(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return setIO();
    }
}
