package racingcar;

import racingcar.model.Car;

public class StubCar extends Car {

    public StubCar(String name) {
        super(name);
    }

    @Override
    public void move() {
        position++;
    }
}
