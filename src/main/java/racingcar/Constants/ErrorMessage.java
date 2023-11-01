package racingcar.Constants;

public enum ErrorMessage {

    NUM_POSITIVE("시도 횟수는 양의정수만 입력하세요"),
    SAME_NAME("자동차 이름을 모두 다르게 입력해주세요."),
    EMPTY_NAME("자동차 이름은 1글자 이상이어야 합니다"),
    NAME_LEN_MAX("자동차 이름 길이가 5를 초과합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
