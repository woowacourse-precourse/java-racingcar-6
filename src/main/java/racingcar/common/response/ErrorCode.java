package racingcar.common.response;

public enum ErrorCode {

    CAR_NAME_NULL("자동차 이름을 입력해 주세요."),
    CAR_NAME_INVALID_LENGTH("1글자 이상, 5글자 이하의 자동차 이름을 입력해 주세요."),
    CAR_NAME_CONTAIN_SPACE("공백이 없는 자동차 이름을 입력해 주세요."),
    CAR_NAME_DUPLICATION("중복되지 않는 자동차 이름을 입력해 주세요."),
    RACE_COUNT_INVALID_RANGE("1 이상의 경주 횟수를 입력해 주세요."),
    NOT_NUMBER_STRING("경주 횟수는 숫자를 입력해 주세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
