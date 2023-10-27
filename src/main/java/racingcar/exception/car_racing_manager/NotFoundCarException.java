package racingcar.exception.car_racing_manager;

public class NotFoundCarException extends IllegalArgumentException {

    public NotFoundCarException(final String carName) {
        super(carName + "을(를) 찾을 수 없습니다.");
    }
}
