package racingcar.domain;

import static racingcar.domain.Constant.MAXIMUM_PLAYER_NAME_LENGTH;
import static racingcar.domain.Constant.MINIMUM_RACE_COUNT;
import static racingcar.domain.Constant.PLAYER_NAMES_DELIMITER;

public class ErrorMessage {
    public static final String RACE_COUNT_IS_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자로 입력해야 합니다.";
    public static final String RACE_COUNT_IS_NOT_IN_RANGE = "[ERROR] " + MINIMUM_RACE_COUNT + " 이상의 숫자를 입력해야 합니다.";
    public static final String PLAYER_NAME_LENGTH_IS_INVALID =
            "[ERROR] 이름은 " + MAXIMUM_PLAYER_NAME_LENGTH + "자 이하로 입력해야 합니다.";
    public static final String PLAYER_NAMES_IS_INVALID_FORMAT =
            "[ERROR] " + PLAYER_NAMES_DELIMITER + "로 구분되게 입력되어야 합니다.";

    private ErrorMessage() {
    }
}
