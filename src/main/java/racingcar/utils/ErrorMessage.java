package racingcar.utils;

public enum ErrorMessage {
    INVALID_NAME_CONDITION("이름은 공백 없는 1~5자의 영어 또는 한글이어야 합니다."),
    INVALID_NAME_NUMBER("자동차의 갯수는 2~5개 사이여야 합니다."),
    DUPLICATE_CAR_NAME("중복되는 자동차 이름이 존재합니다."),
    INVALID_NAMES_INPUT("올바른 이름 형식이 아닙니다. ex) jun,pobi,woni"),
    INVALID_DIGIT_FORM("숫자의 형식이 아닙니다."),
    INVALID_ROUND_RANGE_INPUT("횟수는 2이상 10이하만 입력할 수 있습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
