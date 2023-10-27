package racingcar.util;

import racingcar.domain.CarName;

public enum ExceptionMessage {
    CHECK_NAME_LENGTH(String.format("자동차 이름은 1자 이상 %d자 이하로 입력해주세요.", CarName.NAME_LENGTH)),
    CHECK_NAME_EMPTY("공백만 입력되었습니다.");

    public static final String ERROR = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(ERROR, message);
    }

    public String getMessage() {
        return message;
    }
}
