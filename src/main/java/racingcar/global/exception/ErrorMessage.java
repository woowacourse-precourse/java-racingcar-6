package racingcar.global.exception;

import static racingcar.global.constants.NumberType.MIN_CAR_SIZE;
import static racingcar.global.constants.NumberType.MIN_RACE_COUNT;

public enum ErrorMessage {
    /* Count */
    INVALID_COUNT_FORMAT("숫자 형식으로 입력해주세요."),
    INVALID_COUNT_RANGE(String.format("%d 이상의 정수를 입력해주세요.", MIN_RACE_COUNT.getValue())),

    /* Name */
    INVALID_NAME_LENGTH("5자 이하의 이름을 입력해주세요."),
    INVALID_NAME_CHARACTERS("영문자만 입력해주세요."),

    /* Name List */
    INVALID_NAME_LIST_SIZE(String.format("%d대 이상의 자동차의 이름을 입력해주세요.", MIN_CAR_SIZE.getValue())),
    DUPLICATE_NAME("중복된 이름이 있습니다."),

    /* InputView */
    BLANK_INPUT_ERROR("공백이 입력되었습니다."),
    INVALID_DELIMITER_ERROR("쉼표(,)를 올바르게 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
