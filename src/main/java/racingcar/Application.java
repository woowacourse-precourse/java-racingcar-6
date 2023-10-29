package racingcar;

import java.util.List;
import racingcar.domain.caractions.Car;
import racingcar.domain.caractions.CarFactory;
import racingcar.domain.inputhandler.AttemptNumberInputter;
import racingcar.domain.inputhandler.CarNameInputter;
import racingcar.domain.outputhandler.CarStateOutputter;

public class Application {
    public static void main(String[] args) {
        CarNameInputter carNameInputter = new CarNameInputter();
        List<String> carNameList = carNameInputter.splitCarNames(carNameInputter.getCarNames());
        carNameInputter.validateCarName(carNameList);
        List<Car> cars = CarFactory.createCarsFromNames(carNameList);  // 수정된 부분
        CarStateOutputter carStateOutputter = new CarStateOutputter(cars);
        carStateOutputter.printCarNames();
        AttemptNumberInputter attemptNumberInputter = new AttemptNumberInputter();
        int attemptNumber = attemptNumberInputter.getAttemptNumber();
        carStateOutputter.startRace(attemptNumber);
        carStateOutputter.printChampion();
    }
}
