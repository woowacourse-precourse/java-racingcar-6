package racingcar.util.error;

public enum ErrorMessage {
    NO_NUMBER("[ERROR] 하나의 숫자만 입력해주세요."),
    LOW_NUMBER("[ERROR] 횟수는 1 이상이어야 합니다."),
    OVER_NAME_LENGTH("[ERROR] 이름은 5자 이하만 가능합니다."),
    NO_INPUT_ELEMENT("[ERROR] 빈 값은 입력이 불가능합니다."),
    NO_ELEMENT_IN_NAMELIST("[ERROR] 이름을 기입하셔야 합니다.");

    private final String errorMessage;
    private ErrorMessage(final String message) {
        this.errorMessage = message;
    }
    @Override
    public String toString() {
        return errorMessage;
    }
}
