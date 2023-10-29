package racingcar.global;

import static racingcar.global.Constant.MAX_CAR_NAME_LENGTH;

public enum ErrorMessage {
    EXCEED_CAR_NAME_LENGTH(String.format("%d자리 이상인 자동차 이름이 존재 합니다.", MAX_CAR_NAME_LENGTH)),
    DUPLICATED_CAR_NAME("중복된 자동차 이름이 존재 합니다."),
    EMPTY_CAR_NAME("공백인 자동차 이름이 존재 합니다."),
    NOT_NUMERIC_PLAY_COUNT_STRING("시도할 횟수가 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
