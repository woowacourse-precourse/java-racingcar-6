package racingcar.utils.enums;

public enum ErrorMessage {
    EMPTY_NAME_ERROR("빈 문자열을 입력할 수 없습니다."),
    OVER_THRESHOLD_ERROR("자동차의 이름은 " + Constraints.MAX_SIZE.getValue() + "글자 이하 여야 합니다."),
    NAME_DUPLICATE_ERROR("중복된 자동차 이름이 존재 합니다."),
    NOT_INTEGER_MESSAGE("정수 값을 입력 해야 합니다."),
    NOT_POSITIVE_NUMBER_MESSAGE("시도 회수는 1 이상 이어야 합니다.");

    private final String message;

    ErrorMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
