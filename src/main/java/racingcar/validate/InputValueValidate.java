package racingcar.validate;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.NumberConstant;

import static racingcar.constant.NumberConstant.MAX_LENGTH;

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
        if (name.length() > MAX_LENGTH.getNumber()) {
            Console.close();
            throw new IllegalArgumentException();
        }
    }
}
