package racingcar.view;

import java.io.ByteArrayInputStream;

public abstract class IOTest {
    protected void testInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
