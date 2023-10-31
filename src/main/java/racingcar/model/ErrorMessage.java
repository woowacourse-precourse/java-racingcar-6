package racingcar.model;

public enum ErrorMessage {
    DUPLICATE_NAME("같은 이름의 자동차 이름이 존재합니다."),
    OVER_MAX_CAR_COUNT("저장할 수 있는 자동차의 개수를 초과했습니다."),
    NOT_VALID_CAR_NAME("자동차 이름의 길이가 한 글자 이상 다섯 글자 이하여야 합니다."),
    TOO_MUCH_NUMBER_OF_RACE("너무 많은 회수를 입력하였습니다."),
    TOO_LITTLE_NUMBER_OF_RACE("너무 적은 회수를 입력하였습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
