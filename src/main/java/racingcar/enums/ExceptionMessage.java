package racingcar.enums;

public enum ExceptionMessage {
    SHOULD_BE_FIVE_LETTERS_OR_BELOW("자동차 이름은 5자 이하로 입력해주세요."),
    SHOULD_INPUT_MORE_THAN_ONE_NAME("자동차 이름을 2개 이상 입력해주세요."),
    NAME_CANNOT_BE_BLANK("이름은 빈 칸일 수 없습니다."),
    TOO_LONG_INPUT("너무 긴 값을 입력했습니다."),
    SHOULD_HAVE_UNIQUE_NAMES("이름이 중복되어서는 안 됩니다."),
    SHOULD_INPUT_ONLY_NUMBER("숫자를 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
