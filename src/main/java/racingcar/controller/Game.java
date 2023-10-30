package racingcar.controller;

import static racingcar.view.InputView.askAttemptNumber;
import static racingcar.view.InputView.askCarName;
import static racingcar.view.OutputView.printResult;
import static racingcar.view.OutputView.printWinner;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Game {
    private List<Car> carList;
    private int attemptNumber;

    public void start() {
        Cars cars = new Cars();
        carList = cars.createCarList(askCarName());
        attemptNumber = askAttemptNumber();
        printResult();
        repeat();
        List<String> winners = cars.findWinner();
        printWinner(winners);
    }

    private void repeat() {
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : carList) {
                car.moveForward(car.generateRandomNumber());
                printResult(car);
            }
            System.out.println();
        }
    }
}
