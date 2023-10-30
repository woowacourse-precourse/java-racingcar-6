package racingcar.car;

import racingcar.util.RandomManipulator;

public class CarMover implements Runnable{
    private final Car car;

    CarMover(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        if (RandomManipulator.isMove()) {
            car.move();
        }
    }
}
