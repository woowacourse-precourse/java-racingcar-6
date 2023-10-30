package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.GoStopCar;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void playGame(String carNamesInput, int numberOfAttempts) {
        List<Car> cars = createCars(carNamesInput);
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            moveCars(cars);
        }
        List<String> winners = determineWinners(cars);
        OutputView.printGameResult(cars, numberOfAttempts);
        OutputView.printWinners(winners);
    }
}
