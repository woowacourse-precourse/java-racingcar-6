package racingcar.common.exception;

import racingcar.common.constant.GuidePhrases;

import java.util.List;

public class EmptyInputException {
    public static void isEmptyInput(List<String> carsName) {
        if (carsName.size() == 0) {
            throw new IllegalArgumentException(GuidePhrases.emptyInputPhrase);
        }
    }
}
