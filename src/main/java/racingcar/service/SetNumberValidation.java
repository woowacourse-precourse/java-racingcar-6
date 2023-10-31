package racingcar.service;

import static racingcar.consts.ConstString.WRONG_INT_INPUT;

public class SetNumberValidation {
    public void validateNumber(String userNum){
        checkNotNumber(userNum);
    }

    private static void checkNotNumber(String userNum){
        if (!String.valueOf(userNum).matches("\\d+")) {
            throw new IllegalArgumentException(WRONG_INT_INPUT);
        }
    }
}
