package racingcar.global.enums;

public enum ExceptionMessage {

    EXCEED_MAX_LENGTH_MESSAGE("이름의 길이가 너무 깁니다."),
    NULL_OR_EMPTY_INPUT_MESSAGE("입력값이 null 또는 빈 문자열입니다."),
    NAME_HAS_WHITE_SPACE_MESSAGE("이름에 공백이 포함되어 있습니다."),
    NON_NUMERIC_INPUT_ERROR_MESSAGE("입력값은 숫자여야 합니다."),
    TRIAL_MINIMUM_MESSAGE("시행 횟수는 숫자 1 이상이여야 합니다."),
    DUPLICATE_NAME_MESSAGE("중복된 자동차 이름입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
