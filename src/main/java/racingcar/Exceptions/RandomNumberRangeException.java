package racingcar.Exceptions;

public class RandomNumberRangeException extends IllegalArgumentException {
    public RandomNumberRangeException() {
        super("랜덤으로 생성된 숫자가 0 - 9 사이의 숫자가 아닙니다.");
    }
}
