package racingcar.Exceptions;

public class CarPositionRangeException extends IllegalArgumentException {
    public CarPositionRangeException() {
        super("자동차의 위치가 최소(0) - 최대(2,147,483,648) 범위를 벗어났습니다.");
    }
}
