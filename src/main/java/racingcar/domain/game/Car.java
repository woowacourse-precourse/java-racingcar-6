package racingcar.domain.game;

public class Car {
    private final CarName carName;
    private final int position = 0;

    private Car(CarName carName) {
        this.carName = carName;
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }
}
