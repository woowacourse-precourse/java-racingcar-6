package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.race.GameCount;
import racingcar.model.race.Race;
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
        GameCount gameCount = GameCount.from(inputView.askGameCount());
        startRace(cars, gameCount);
        printResult();
        printWinners();
    }

    private Cars createCarsFromCarNames(String[] input) {
        List<Car> carNameList = Arrays.stream(input).map(Car::from).toList();
        return Cars.from(carNameList);
    }

    private void startRace(Cars cars, GameCount count) {
        race = Race.of(cars, count);
        race.start();
    }

    private void printResult() {
        resultView.printResult(race.getResult());
    }

    private void printWinners() {
        Winners winners = Winners.from(race.getResult());
        resultView.printWinners(winners);
    }
}
