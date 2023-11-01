package racingcar.entity;

import racingcar.io.Read;
import racingcar.exception.NumberException;

public class Tries {
    public static int getTries() {
        String input = Read.input();
        NumberException.validateNumber(input);
        return Integer.parseInt(input);
    }
}
