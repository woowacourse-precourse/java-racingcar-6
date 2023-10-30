package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.ExceptionCheck;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Cars cars;
    private int repeatNumber;

    public void runGame() {
        inputNames();
        inputRepeatNumber();
        repeatRacing();
        resultWinner();
    }
    private void inputNames() {
        OutputView.printCarName();
        List<String> carList = Arrays.asList(InputView.readLine().split(","));

        this.cars = new Cars(carList);
    }

    private void inputRepeatNumber() {
        OutputView.printRepeatNumber();
        repeatNumber = Integer.parseInt(InputView.readLine());
        ExceptionCheck.iterateNumberValidation(repeatNumber);
    }

    private void repeatRacing() {
        OutputView.printResult();
        for (int i = 0; i < repeatNumber; i++) {
            cars.forwardCars();
        }
    }

    private void resultWinner() {
        OutputView.printWinner(cars.winner());
    }
}
