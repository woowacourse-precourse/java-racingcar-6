package racingcar.constant;

public enum ValidatorConstant {

    ERROR_MESSAGE_NAME_INPUT("잘못된 입력입니다. 자동차 이름을 입력해주세요."),
    ERROR_MESSAGE_NAME_DUPLICATE("동일한 자동차 이름이 이미 존재합니다."),

    ERROR_MESSAGE_NAME_BLANK("자동차 이름 안에 공백이 있지 않아야 합니다."),

    ERROR_MESSAGE_NAME_MAX("자동차 이름은 5글자를 초과해서는 안됩니다."),
    ERROR_MESSAGE_NAME_MIN("자동차 이름은 1글자 이상이어야 합니다."),

    ERROR_MESSAGE_NUMBER_INPUT("잘못된 입력입니다. 시도할 횟수를 입력해주세요."),
    ERROR_MESSAGE_NUMBER_TYPE("시도할 횟수는 정수만 입력 가능합니다.");

    private final String message;

    ValidatorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
