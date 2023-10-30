package racingcar.utils;

public enum ExceptionMessage {
    BLANK("공백 입력을 해선 안됩니다."),
    FIRST_CHARACTER_COMMA("첫 번째 문자로 콤마(,)를 입력하면 안됩니다."),
    LAST_CHARACTER_COMMA("마지막 문자로 콤마(,)를 입력하면 안됩니다."),
    ELEMENT_BLANK("자동차 이름은 공백 문자로만 이루어져선 안됩니다."),
    OUT_OF_LENGTH("자동차 이름은 5글자 이하여야 합니다."),

    NOT_NUMERIC("숫자만 입력해야 합니다."),
    OUT_OF_INTEGER_RANGE("int 범위를 벗어났습니다."),
    OUT_OF_RANGE("1회 ~ 2147483647회 만 입력 가능합니다.");

    private final String error;

    ExceptionMessage(String error) {
        this.error = error;
    }

    String getError() {
        return error;
    }

}
