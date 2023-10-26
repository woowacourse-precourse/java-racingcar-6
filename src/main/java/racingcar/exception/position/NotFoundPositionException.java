package racingcar.exception.position;

public class NotFoundPositionException extends IllegalArgumentException {
    public NotFoundPositionException(final int positionIndex) {
        super(positionIndex + "번째 위치를 찾을 수 없습니다.");
    }
}
