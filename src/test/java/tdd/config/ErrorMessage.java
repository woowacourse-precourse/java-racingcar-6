package tdd.config;

import static tdd.config.RacingConfig.ATTEMPT_COUNT_MAX;
import static tdd.config.RacingConfig.ATTEMPT_COUNT_MIN;
import static tdd.config.RacingConfig.CAR_NAME_SPLIT_DELIM;
import static tdd.config.RacingConfig.INPUT_CAR_NAME_LENGTH_MAX;
import static tdd.config.RacingConfig.INPUT_CAR_NAME_LENGTH_MIN;
import static tdd.config.RacingConfig.SPLIT_CAR_NAME_LENGTH_MAX;
import static tdd.config.RacingConfig.SPLIT_CAR_NAME_LENGTH_MIN;

public enum ErrorMessage {
    SPLIT_CAR_REGEX_ERROR_MESSAGE("자동차 이름은 영어 소문자, 숫자만 입력 가능합니다. 잘못 입력한 자동차 이름 : %s"),
    SPLIT_CAR_LENGTH_ERROR_MESSAGE(String.format("자동차 이름의 길이는 %d자 이상 %d자 이하여야 합니다.",
            SPLIT_CAR_NAME_LENGTH_MIN.getValue(), SPLIT_CAR_NAME_LENGTH_MAX.getValue())),
    SPLIT_CAR_UNIQUE_ERROR_MESSAGE("자동차 이름은 서로 다른 이름만 입력해야 합니다. 잘못 입력한 자동차 이름 : %s"),
    INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE(String.format("입력값은 %d자 이상 %d자 이하여야 합니다.",
            INPUT_CAR_NAME_LENGTH_MIN.getValue(), INPUT_CAR_NAME_LENGTH_MAX.getValue())),

    INPUT_CAR_NAME_COMMA_ERROR_MESSAGE(String.format("입력값의 처음 또는 마지막에 %s가 존재해선 안 됩니다.",
            CAR_NAME_SPLIT_DELIM.getContent())),
    ATTEMPT_COUNT_ERROR_MESSAGE(String.format("게임 시도 횟수는 %d번 이상 %d번 이하의 자연수여야 합니다.",
            ATTEMPT_COUNT_MIN.getValue(), ATTEMPT_COUNT_MAX.getValue()));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
