package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.Output;

public class RacingController {

    private Racing racing = new Racing();

    public List<Car> race(List<String> carNames, int NumberOfExecutions) {
        createCars(carNames);
        Output.printIntroductionOfResult();
        for (int i = 0; i < NumberOfExecutions; i++) {
            racing.moveCars();
            Output.printResultOfEachExecution(racing.getCarList());
        }
        return racing.getWinners();
    }

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            racing.addCar(car);
        }
    }

}
