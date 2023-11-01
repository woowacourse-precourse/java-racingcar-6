package racingcar.common.util;

public enum ErrorMessage {

    VALIDATE_NOT_NUMBER("입력된 문자열에 숫자 이외의 문자가 포함되어 있습니다."),
    VALIDATE_LIMIT_NAME("자동차 이름은 5글자 이하로 입력해 주세요."),
    VALIDATE_UNIQUE_CAR_NAME("중복된 자동차 이름 : "),
    VALIDATE_NO_CAR_NAME("레이싱에 필요한 자동차 이름이 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
