package racingcar.constant;

public enum ExceptionResponse {
    INPUT_CAR_NAMES("자동차 이름을 입력해야 합니다."),
    INPUT_TRIAL_COUNT("시도할 횟수를 입력해야 합니다."),
    NUMERIC("숫자를 입력해야 합니다."),
    POSITIVE_NUMBER("숫자는 0보다 커야 합니다."),
    RACING_CAR_NAME("이름은 5자 이하의 구분 가능한 문자로 이루어져야 합니다."),
    DUPLICATE_RACING_CAR("중복된 이름을 가진 자동차는 없어야 합니다.");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
