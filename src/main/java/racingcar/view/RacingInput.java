package racingcar.view;

import racingcar.utils.InputValidator;

import java.util.List;

public class RacingInput {

    public static List<String> readCarNames(String names) {
        return InputValidator.validateCarNames(names);
    }

    public static int readTryCount(String count) {
        return InputValidator.validateTryCountIsNumber(count);
    }
}
