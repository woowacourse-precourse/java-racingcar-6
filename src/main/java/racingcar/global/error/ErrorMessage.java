package racingcar.global.error;

public enum ErrorMessage {
    IS_BLANK("자동차의 이름은 공백일 수 없습니다."),
    NOT_CONTAIN_SYMBOL("자동차의 이름은 쉼표(,)를 포함해야 합니다."),
    INVALID_SYMBOL_POSITION("쉼표(,)는 처음과 끝 위치에 올 수 없습니다."),
    INVALID_NAME_LENGTH("자동차의 이름은 5자 이하만 가능합니다."),
    DUPLICATE_NAME("자동차의 이름은 중복을 허용하지 않습니다."),
    TYPE_MISMATCH("시도할 회수는 숫자만 입력 가능합니다."),
    INVALID_COUNT("시도할 회수는 최소 1회 이상입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
