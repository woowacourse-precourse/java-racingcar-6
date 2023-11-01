package racingcar.domain;

public class AlwaysMovingCar extends Car {
    public AlwaysMovingCar(String name) {
        super(name);
    }

    @Override
    public boolean isMovable() {
        return true;
    }
}
