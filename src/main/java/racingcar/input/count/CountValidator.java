package racingcar.input.count;

import racingcar.constant.ErrorMessage;

public class CountValidator {
    public static void isValid(String inputCount) {

        if(!inputCount.matches("[0-9]+")) {
            throw new IllegalArgumentException(ErrorMessage.getErrorMessage("count"));
        }
    }
}
