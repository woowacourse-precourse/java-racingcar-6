package racingcar.io;

import static racingcar.constant.Constants.INPUT_SEPARATOR;
import static racingcar.constant.ExceptionMessage.DUPLICATED_CAR_NAME;
import static racingcar.constant.ExceptionMessage.INVALID_TRIAL_NUMBER;
import static racingcar.constant.ExceptionMessage.LENGTH_OUT_OF_RANGE_CAR_NAME;
import static racingcar.constant.ExceptionMessage.NOT_ALLOWED_WORDS_CAR_NAME;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.util.StringManipulator;

public class InputHandler {
    public static String readLine() {
        return Console.readLine();
    }
    public static List<String> convertCarNames(String carNamesWithSeparator) {
        String[] carNameGroup = StringManipulator.splitSeparator(carNamesWithSeparator, INPUT_SEPARATOR);
        checkValidCarNames(carNameGroup);
        List<String> carNames = StringManipulator.toList(carNameGroup);

        return carNames;
    }

    public static int convertTrialNumber(String trialNum) {
        checkValidTryNumber(trialNum);
        return Integer.parseInt(trialNum);
    }

    private static void checkValidCarNames(String[] carNameGroup) {
        if (!StringManipulator.isValidLength(carNameGroup)) {
            throw new IllegalArgumentException(LENGTH_OUT_OF_RANGE_CAR_NAME);
        }

        if (StringManipulator.hasDuplicates(carNameGroup)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }

        if (!StringManipulator.isValidNames(carNameGroup)) {
            throw new IllegalArgumentException(NOT_ALLOWED_WORDS_CAR_NAME);
        }
    }

    private static void checkValidTryNumber(String trialNum) {
        if (!trialNum.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException(INVALID_TRIAL_NUMBER);
        }
    }
}
