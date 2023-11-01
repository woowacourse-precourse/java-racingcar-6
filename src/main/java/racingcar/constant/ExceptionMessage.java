package racingcar.constant;

public enum ExceptionMessage {

    DUPLICATE_CAR_NAME("입력한 자동차의 이름 중 동일한 이름이 존재합니다."),
    OVER_SIZE_CAR_NAME("자동차의 이름은 5글자를 초과할 수 없습니다."),
    EMPTY_CAR_NAME("자동차 이름은 공백을 사용할 수 없습니다."),
    NOT_NUMBER_MESSAGE("숫자를 제외한 문자는 입력하실 수 없습니다."),
    ZERO_NUMBER_MESSAGE("게임 횟수는 1보다 크거나 같고 100_000 보다 작거나 같은 양의 정수여야 합니다."),
    MAX_VALUE_MESSAGE("100_000 보다 작거나 같은 양의 정수값을 입력해야 합니다."),
    NO_WINNER_MESSAGE("참여한 모든 자동차의 이동거리 0 이므로, 우승자가 없습니다."),
    ;

    final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
