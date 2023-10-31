package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.race.Race;
import racingcar.model.race.RaceGameCount;
import racingcar.model.winner.Winners;
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
        printWinners();
    }

    private Cars createCarsFromCarNames(String[] input) {
        List<Car> carList = Arrays.stream(input).map(Car::from).toList();
        return Cars.from(carList);
    }

    private void printResult() {
        resultView.printResult(race.getResult());
    }

    private void printWinners() {
        Winners winners = Winners.from(race.getResult());
        resultView.printWinners(winners);
    }
}
