package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public class RacingController {

    private Racing racing = new Racing();

    public void race(List<String> carNames, int NumberOfExecutions) {
        createCars(carNames);
        for (int i = 0; i < NumberOfExecutions; i++) {
            racing.moveCars();
        }
    }

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            racing.addCar(car);
        }
    }


}
