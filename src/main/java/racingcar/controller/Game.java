package racingcar.controller;

import static racingcar.view.InputView.askAttemptNumber;
import static racingcar.view.InputView.askCarName;
import static racingcar.view.OutputView.printResult;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Game {
    public void start() {
        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(askCarName());
        int attemptNumber = askAttemptNumber();
        printResult();
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : carList) {
                car.moveForward(car.generateRandomNumber());
                printResult(car);
            }
            System.out.println();
        }
    }
}
