package racingcar.constants;

public enum ErrorCode {
    INVALID_NAME_LENGTH("이름의 길이가 유효하지 않습니다."),
    DUPLICATED_NAME("중복되는 이름이 존재합니다"),
    INVALID_INPUT("입력한 값이 숫자가 아니거나 범위가 유효하지 않습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
