package racingcar.message;

public enum ErrorMessage {
    CAR_NAME_OVER_SIZE_ERROR("자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAME_NULL_ERROR("자동차 이름은 공백이 불가합니다."),
    INVALID_CAR_LIST("잘못된 CarList를 참조하고 있습니다."),
    DUPLICATED_CAR_NAME_ERROR("중복된 이름의 자동차는 존재할 수 없습니다."),
    TRY_COUNT_MUST_BE_NUMBER("시도 횟수는 숫자여야 합니다.");

    public final String message;
    private static final String prefix = "[ERROR]";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.join(" ", prefix, message);
    }
}
