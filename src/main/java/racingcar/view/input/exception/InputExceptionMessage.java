package racingcar.view.input.exception;

import static racingcar.global.Constants.ERROR_PREFIX;

public enum InputExceptionMessage {
    IS_EMPTY("비어있는 입력입니다."),
    NOT_NUMERIC_TYPE("숫자 형식의 입력이 아닙니다."),
    NUMERIC_INPUT_UNDER_LOWER_LIMIT("양수 형식의 입력이 아닙니다."),
    INPUT_DOES_NOT_CONTAIN_DELIMITER("최소 두 개 이상의 지동차를 입력해야 합니다."),
    CONTAINS_EMPTY_INPUT("구분자로 구분된 값 중, 비어있는 입력값을 포함하고 있습니다.");

    private final String message;

    InputExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}