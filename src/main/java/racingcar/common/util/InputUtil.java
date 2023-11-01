package racingcar.common.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.common.message.ErrorConstant.NOT_INTEGER_ERROR_MESSAGE;
import static racingcar.common.message.GameConstant.INPUT_TRY_NUMBER_MESSAGE;

public class InputUtil {
    private final Validator validator;

    public InputUtil(Validator validator) {
        this.validator = validator;
    }

    public int inputAttemptNumber() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
        String numberString = readLine();
        if (!validator.isInt(numberString)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
        return Integer.parseInt(numberString);
    }
}
