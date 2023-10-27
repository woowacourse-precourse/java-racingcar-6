package racingcar.exception.position;

public class NotExistPositionException extends IllegalArgumentException {

    public NotExistPositionException(final int positionIndex) {
        super(positionIndex + "번째 위치는 존재하지 않습니다.");
    }

    public NotExistPositionException() {
        super("위치가 존재하지 않습니다.");
    }
}
