package racingcar.domain;

public enum ErrorMessage {
    INVALID_MINIMUM_CAR_COUNT("최소 1대의 자동차가 입력되어야 합니다."),
    CAR_NAME_IS_BLANK("자동차 이름이 공란입니다."),
    EXCEEDED_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    ATTEMPT_COUNT_IS_NOT_NUMBER("시도할 횟수는 숫자만 입력이 가능합니다."),
    INVALID_MINIMUM_ATTEMPT_COUNT("시도할 횟수는 1 이상이어야 게임 진행이 가능합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
