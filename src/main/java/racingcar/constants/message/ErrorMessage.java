package racingcar.constants.message;

public enum ErrorMessage {

    DIVISION_CAR_NAME_ERROR("이름은 쉼표(,) 기준으로 구분해야 합니다."),
    CAR_NAME_LENGTH_ERROR("자동차 이름은 5자 이하만 가능합니다."),
    CARS_COUNT_ERROR("자동차 이름을 2개 이상 입력해주세요"),
    INPUT_NUMERIC_ERROR("숫자를 입력해 주세요"),
    NOT_FOUND_MAX_CAR_POSITION("레이싱카의 최대 위치를 찾지 못했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
