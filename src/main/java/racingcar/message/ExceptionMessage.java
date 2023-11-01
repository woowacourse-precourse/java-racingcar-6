package racingcar.message;

public enum ExceptionMessage {
    OVER_FIVE_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    IS_NOT_DIGIT("시도 횟수는 숫자만 입력 가능합니다."),
    IS_DUPLICATE("자동차 이름은 중복이 없어야 합니다."),
    IS_NOT_RIGHT_PATTERN("자동차 이름은 콤마로 구분되어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
