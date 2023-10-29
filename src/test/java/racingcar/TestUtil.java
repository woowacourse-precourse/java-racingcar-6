package racingcar;

import java.io.ByteArrayInputStream;

public class TestUtil {
    static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
