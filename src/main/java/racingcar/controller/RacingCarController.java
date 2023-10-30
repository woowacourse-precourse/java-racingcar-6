package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.race.Race;
import racingcar.model.race.RaceGameCount;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {

    private final InputView inputView;
    private final ResultView resultView;
    private Race race;

    public RacingCarController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        Cars cars = createCarsFromCarNames(inputView.askCarNames());
        RaceGameCount raceGameCount = RaceGameCount.from(inputView.askGameCount());
        race = Race.of(cars, raceGameCount);
        race.start();
        printResult();
    }

    private void printResult() {
        resultView.printResult(race.getResult());
    }

    private Cars createCarsFromCarNames(String[] input) {
        List<Car> carList = Arrays.stream(input).map(Car::from).toList();
        return Cars.from(carList);
    }
}
