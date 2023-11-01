package racingcar.service;

import racingcar.domain.Car;

public class CarService {

    private final int FORWARD_COUNT;

    public CarService(int FORWARD_COUNT) {
        this.FORWARD_COUNT = FORWARD_COUNT;
    }

    public void ForwardOrStop(Car car) {

        int engine = car.generateRandomNumber();

        if (isForward(engine)) {
            car.forward();
        }
    }

    private boolean isForward(int engine) {
        return engine >= FORWARD_COUNT;
    }
}
