package racingcarv2.exception;

public enum ErrorException {
    OVER_MAX_INTEGER("최대치를 넘긴 수를 입력했습니다"),
    OUT_OF_RANGE("문자열의 길이가 범위에서 벗어났습니다"),
    DUPLICATED_NAME("중복된 이름이 존재합니다"),
    NOTHING_INPUT("아무것도 입력하지 않았습니다"),
    WRONG_FORMAT("형식에 맞지 않는 입력입니다"),
    NOT_NUMBER("숫자를 입력하지 않았습니다"),
    START_WITH_ZERO("0으로 시작하는 수를 입력했습니다"),
    ;

    private final String description;

    ErrorException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
