package racingcar.exception;

public enum ErrorMessage {

    INVALID_NAME("이름은 특수 기호를 포함해선 안됩니다."),
    INVALID_NAME_LENGTH("각 차 이름은 5글자 미만이어야 합니다."),
    DUPLICATE_NAME("중복된 이름이 존재합니다."),
    BLANK_NAME("쉼표 사이에 이름이 입력되어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public InvalidNameException getNameException(){
        return new InvalidNameException(this.message);
    }
}
