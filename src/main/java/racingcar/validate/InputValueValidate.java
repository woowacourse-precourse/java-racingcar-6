package racingcar.validate;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.NumberConstant.*;

public class InputValueValidate {
    static public int checkTimesException(String inputTimes) {
        try {
            return Integer.parseInt(inputTimes);
        } catch (Exception e) {
            Console.close();
            throw new IllegalArgumentException();
        }
    }

    static public void checkNameException(String name) {
        if (name.length() > MAX_LENGTH.getNumber() || name.length() == MIN_LENGTH.getNumber()) {
            Console.close();
            throw new IllegalArgumentException();
        }
    }
}
