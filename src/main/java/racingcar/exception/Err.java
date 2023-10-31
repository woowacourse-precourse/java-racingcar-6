package racingcar.util;

public enum Err {
    INVALID_CAR_NAME_MIN_LENGTH("자동차 이름은 1글자 이상 입력하셔야 합니다."),
    INVALID_CAR_NAME_MAX_LENGTH("자동차 이름은 5글자 이하로 입력하셔야 합니다."),
    NUMERIC_STRING_ONLY("숫자로 된 문자열만 입력할 수 있습니다."),
    NON_EMPTY_STRING("입력 문자열은 비어있거나 공백 문자만으로 이루어질 수 없습니다."),
    INVALID_CAR_NAMES_FORMAT("자동차 이름은 쉼표로 구분된 문자열이어야 합니다.");

    private final String message;

    Err(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
