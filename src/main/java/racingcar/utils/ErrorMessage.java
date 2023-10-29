package racingcar.utils;

public enum ErrorMessage {
    INVALID_SPLIT_CHAR("구분자로 쉼표(,)를 사용해야 합니다."),
    INVALID_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    NON_DIGIT_ATTEMP_NUM("시도 횟수는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
