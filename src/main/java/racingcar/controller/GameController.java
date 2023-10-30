package racingcar.controller;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.OutView.printCarsMovingResult;
import static racingcar.view.OutView.printExecutionStart;
import static racingcar.view.OutView.printWinners;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarsGenerator;

public class GameController {

    private final CarsGenerator carsGenerator;

    private Cars cars;

    public GameController(CarsGenerator carsGenerator) {
        this.carsGenerator = carsGenerator;
    }

    public void play() {
        final int turns = prepare();
        process(turns);
        declareWinner();
    }

    private int prepare() {
        final List<Car> carList = carsGenerator.generate(inputCarNames());
        cars = new Cars(carList);
        return inputAttemptCount();
    }

    private void process(final int turns) {
        printExecutionStart();
        for (int i = 0; i < turns; i++) {
            cars.processTurn();
            printCarsMovingResult(cars.getCarList());
        }
    }

    private void declareWinner() {
        final List<String> winners = cars.judge();
        printWinners(winners);
    }

}
