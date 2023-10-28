package racingcar.exception;

public enum ErrorException {
    NOTHING_INPUT("아무것도 입력하지 않았습니다"),
    NOT_ENGLISH_NAME("영문 이름을 작성해주세요."),
    START_WITH_ZERO("0으로 시작하는 수를 입력했습니다"),
    NOT_NUMBER("숫자를 입력해주세요"),
    OVER_STANDARD_LENGTH("5글자가 넘어갔습니다"),
    DUPLICATED_NAMES("중복된 이름이 존재합니다"),
    OUT_OF_RANGE("범위에서 벗어난 수입니다"),
    ;

    private final String errorDescription;

    ErrorException(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
