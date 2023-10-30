package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
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
        List<Car> carList = Arrays.stream(InputView.read().split(","))
            .map(Car::new)
            .collect(Collectors.toList());

        this.cars = new Cars(carList);
    }

    private void inputRepeatNumber() {
        OutputView.printRepeatNumber();
        repeatNumber = Integer.parseInt(InputView.read());
    }

    private void repeatRacing() {
        OutputView.printResult();
        for (int i = 0; i < repeatNumber; i++) {
            cars.moveCars();
        }
    }

    private void resultWinner() {
        OutputView.printWinner(cars.winner());
    }
}
