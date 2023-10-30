package racingcar.view;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public abstract class IOTest {

    void allocateSystemIn(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
    }

}
