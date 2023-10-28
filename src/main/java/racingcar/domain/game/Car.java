package racingcar.domain.game;

public class Car {
    protected final CarName carName;
    protected int position = 0;

    protected Car(CarName carName) {
        this.carName = carName;
    }

    public static Car from(CarName carName) {
        return new Car(carName);
    }

    public void moveOnce() {
        position++;
    }
}
