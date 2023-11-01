package racingcar.domain;

public class NeverMovingCar extends Car {
    public NeverMovingCar(String name) {
        super(name);
    }

    @Override
    public boolean isMovable() {
        return false;
    }
}
