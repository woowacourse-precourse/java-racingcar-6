package racingcar.service;

import racingcar.domain.Car;

public class CarService {

    public void ForwardOrStop(Car car) {
        int engine = car.generateRandomNumber();
        boolean isForward = (engine >= 4);

        if (isForward) {
            car.forward();
        }
    }
}
