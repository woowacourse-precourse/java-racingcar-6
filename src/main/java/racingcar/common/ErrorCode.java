package racingcar.common;

public enum ErrorCode {
    INPUT_WRONG_CAR_NAME_LENGTH("길이가 잘못된 자동차 이름입니다."),
    INPUT_WRONG_CAR_NAME_EMPTY("자동차 이름이 비어있습니다."),
    INPUT_WRONG_CAR_NAME_NULL("자동차 이름이 null입니다."),
    INPUT_WRONG_NUMBER("잘못된 숫자를 입력하셨습니다. (숫자 범위는 0~9)");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
