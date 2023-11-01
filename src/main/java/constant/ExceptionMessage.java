package constant;

import domain.Car;

public enum ExceptionMessage {
    INCORRECT_NUMBER_INPUT("잘못된 입력입니다. 숫자를 입력해 주세요."),
    NEGATIVE_NUMBER_INPUT("잘못된 입력입니다. 양수를 입력해 주세요."),
    NAME_LENGTH_EXCEEDED(String.format("이름 길이 한도를 초과했습니다. 각 이름은 %d글자 이하로 입력해 주세요.", Car.MAXIMUM_NAME_LENGTH)),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
