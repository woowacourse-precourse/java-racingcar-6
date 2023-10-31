package racingcar.service;

import racingcar.domain.Car;

public class CarService {

    public void ForwardOrStop(Car car) {

        int engine = car.generateRandomNumber();

        if (isForward(engine)) {
            car.forward();
        }
    }

    private boolean isForward(int engine) {

        return engine >= 4;
    }
}
