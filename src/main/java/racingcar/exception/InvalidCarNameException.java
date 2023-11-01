package racingcar.exception;

public class InvalidCarNameException extends IllegalArgumentException {
    public InvalidCarNameException() {
        super("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }
}
