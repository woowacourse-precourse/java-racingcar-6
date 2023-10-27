package racingcar.util.messages.ErrorMessages;

public enum CarNameInputErrorMessages {
    LIST_EMPTY_ERROR_MESSAGE("자동차 이름을 입력하지 않았습니다."),
    NAME_LENGTH_ERROR_MESSAGE("자동차 이름이 5자를 초과합니다."),
    NAME_DUPLICATE_ERROR_MESSAGE("자동차 이름이 중복으로 입력되었습니다.");


    private final String message;

    private CarNameInputErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
