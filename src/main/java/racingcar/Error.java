package racingcar;

public enum Error {
    CAR_NAME_LENGTH_ERROR("자동차의 이름은 이름은 1자 이상 5자 이하만 가능합니다."),
    DUPLICATE_CAR_NAME_ERROR("중복된 자동차 이름을 입력하였습니다."),
    INVALID_TRY_COUNT_ERROR("시도할 회수는 자연수만 가능합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
