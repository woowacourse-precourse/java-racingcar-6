package racingcar.utils.constant.message;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 숫자가 아닙니다."),
    TOO_LONG("[ERROR] 5자리 이하의 이름만 사용가능 합니다."),
    NOTHING("[ERROR] 숫자를 입력해 주세요."),
    TOO_FEW_NAMES("[ERROR] 2개 이상의 자동차 이름을 입력해 주세요."),
    MORE_THAN_ZERO("[ERROR] 0보다 큰 수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}