package racingcar.exception.numberOfRounds;

public class NonPositiveNumberException extends IllegalArgumentException{
    public NonPositiveNumberException() {
        super("양수를 입력하지 않았습니다.");
    }
}
