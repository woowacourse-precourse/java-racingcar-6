package racingcar.util;

import racingcar.en.NumExceptionEnum;

public class InputValidator {

    private final static int LENGTH_LIMIT = 5;

    public static void checkLength(String value) {
        String[] carNames = value.split(",");

        for (String name : carNames){
            if (name.length() > LENGTH_LIMIT) {
                throw new IllegalArgumentException(NumExceptionEnum.WRONG_LENGTH.msg);
            }
        }

    }


    public static void checkNum(String value) {
        if (value != null && !value.matches("^[^0]\\d*")){
            throw new IllegalArgumentException(NumExceptionEnum.NOT_INTEGER.msg);
        }
    }
}
