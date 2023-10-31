package racingcar.constant;

public enum ExceptionMessage {
    COUNT_INPUT_EXCEPTION_MESSAGE("숫자만 입력해주십시오."),
    ONLY_NUMBER_REGEX("\\d+"),
    NAME_DUPLICATION_EXCEPTION_MESSAGE("자동차의 이름은 중복되지 않게 입력해주십시오."),
    NAME_LENGTH_EXCEPTION_MESSAGE("각 자동차의 이름은 1자 이상 " + GameSettingNumber.MAX_LENGTH + "자 이하여야 합니다."),
    NAMES_COUNT_EXCEPTION_MESSAGE("2개 이상의 자동차의 이름을 입력해 주십시오.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
