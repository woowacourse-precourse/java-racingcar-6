package racingcar.exception.round;

public class NonPositiveIntegerException extends IllegalArgumentException{
    public NonPositiveIntegerException() {
        super("양수를 입력하지 않았습니다.");
    }
}
