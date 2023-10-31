package racingcar;

import java.io.ByteArrayInputStream;
import camp.nextstep.edu.missionutils.Console;

public abstract class InputTest {

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    protected void clean() {
        Console.close();
    }
}
