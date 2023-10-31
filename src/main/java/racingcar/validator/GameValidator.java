package racingcar.validator;

import racingcar.constants.GameConstants;

public class GameValidator {
    public static void validationCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 입력 가능합니다.");
        }
    }

    public static void validationMoveCntIsNumber(String moveCnt) {
        if (!moveCnt.matches(GameConstants.ONLY_NUMBER_REGEX_PATTERN)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
