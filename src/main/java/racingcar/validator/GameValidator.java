package racingcar.validator;

import racingcar.constants.GameConstants;

public class GameValidator {
    public static void validationCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXECESS.getErrorMessage());
        }
    }

    public static void validationMoveCntIsNumber(String moveCnt) {
        if (!moveCnt.matches(GameConstants.ONLY_NUMBER_REGEX_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER_POSSIBLE.getErrorMessage());
        }
    }
}
