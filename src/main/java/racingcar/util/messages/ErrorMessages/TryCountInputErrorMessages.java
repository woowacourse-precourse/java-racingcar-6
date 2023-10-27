package racingcar.util.messages.ErrorMessages;

public enum TryCountInputErrorMessages {
    EMPTY_ERROR_MESSAGE("시도 회수를 입력하지 않았습니다."),
    WRONG_INPUT_ERROR_MESSAGE("잘못된 값을 입력하였습니다."),
    UNDER_ONE_ERROR_MESSAGE("1 이상의 값을 입력하지 않았습니다.");

    private final String message;

    private TryCountInputErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
