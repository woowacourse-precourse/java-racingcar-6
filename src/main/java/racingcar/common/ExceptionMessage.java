package racingcar.common;

import racingcar.common.Constants;

public enum ExceptionMessage {
    ENDS_WITH_COMMA("쉼표(,) 이후에 자동차 이름을 입력해 주세요."),
    MORE_THAN_ALLOWED_NAME_LENGTH("5글자 이하의 자동차 이름을 입력해 주세요."),
    EMPTY_NAME("1글자 이상의 자동차 이름을 입력해 주세요."),
    NOT_NUMBER("숫자를 입력해주세요."),
    NEGATIVE_NUMBER("자연수를 입력해주세요."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return Constants.ERROR + message;
    }
}
