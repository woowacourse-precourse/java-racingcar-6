package racingcar.message;

public enum ErrorMessage {
    OVER_FIVE_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    IS_NOT_DIGIT("시도 횟수는 숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
