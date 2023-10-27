package racingcar.exception.car_racing_manager;

public class NotUniqueCarNameException extends IllegalArgumentException {

    public NotUniqueCarNameException(final String carName) {
        super(carName + "은(는) 중복된 이름입니다.");
    }
}
