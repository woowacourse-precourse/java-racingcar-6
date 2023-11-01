package racingcar.controller;

import racingcar.controller.dto.Result;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.Rule;
import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;
import racingcar.view.Console;

import java.util.List;

public class RacingCarGame {

    private final Console console;
    private final Rule rule;

    public RacingCarGame(Console console, MovingPolicy movingPolicy, NumberGeneratePolicy numberGeneratePolicy) {
        this.console = console;
        this.rule = new Rule(movingPolicy, numberGeneratePolicy);
    }

    public void run() {
        CarNames carNames = new CarNames(console.readCarNames());
        Round round = new Round(console.readNumberOfTrials());
        Cars cars = carNames.generateCars();
        console.printResultMessage();
        for (int i = 0; i < round.getRound(); i++) {
            cars = playEachRound(cars);
        }

        List<Result> winners = cars.calculateWinners();
        console.printWinners(winners);
    }

    private Cars playEachRound(Cars cars) {
        cars = cars.playGame(rule);
        List<Result> results = cars.getResults();
        console.print(results);

        return cars;
    }

}
