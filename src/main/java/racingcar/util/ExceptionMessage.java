package racingcar.util;

import racingcar.domain.Name;

public enum ExceptionMessage {
    CHECK_NAME_LENGTH(String.format("자동차 이름은 1자 이상 %d자 이하로 입력해주세요.", Name.NAME_LENGTH)),
    CHECK_NAME_EMPTY("공백만 입력되었습니다."),
    NOT_NUMERIC("입력값을 다시 확인해주세요.(1 이상의 자연수)");

    private static final String ERROR = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(ERROR, message);
    }

    public String getMessage() {
        return message;
    }
}
