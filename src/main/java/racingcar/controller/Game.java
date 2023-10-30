package racingcar.controller;

import static racingcar.view.InputView.askAttemptNumber;
import static racingcar.view.InputView.askCarName;
import static racingcar.view.OutputView.printResult;
import static racingcar.view.OutputView.printWinner;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Game {
    private int attemptNumber;

    public void start() {
        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(askCarName());
        attemptNumber = askAttemptNumber();
        validate();
        printResult();
        repeat(carList);
        List<String> winners = cars.findWinner();
        printWinner(winners);
    }

    private void repeat(List<Car> carList) {
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : carList) {
                car.moveForward(car.generateRandomNumber());
                printResult(car);
            }
            System.out.println();
        }
    }

    public boolean isValidNumber() {
        return attemptNumber > 0;
    }

    public void validate() {
        if (!isValidNumber()) {
            throw new IllegalArgumentException("입력하신 횟수가 올바르지 않습니다.");
        }
    }
}
