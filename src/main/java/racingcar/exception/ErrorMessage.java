package racingcar.exception;

public enum ErrorMessage {

    INVALID_NAME("이름은 특수 기호를 포함해선 안됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public InvalidNameException getNameException(){
        return new InvalidNameException(this.message);
    }
}
