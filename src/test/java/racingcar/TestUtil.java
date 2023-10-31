package racingcar;

import java.io.ByteArrayInputStream;

class TestUtil {
    static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
