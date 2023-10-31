package racingcar.validate;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InvalidValueException;
import racingcar.exception.LengthExceedException;

import static racingcar.constant.NumberConstant.*;

public class InputValueValidate {
    static public int checkTimesException(String inputTimes) {
        try {
            return Integer.parseInt(inputTimes);
        } catch (Exception e) {
            Console.close();
            throw new InvalidValueException();
        }
    }

    static public void checkNameException(String name) {
        if (name.length() > MAX_LENGTH.getNumber()) {
            Console.close();
            throw new LengthExceedException();
        }
    }
}
