package racingcar.controller;

import racingcar.controller.dto.Result;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;
import racingcar.view.Console;

import java.util.List;

public class RacingCarGame {

    private final Console console;
    private final MovingPolicy movingPolicy;
    private final NumberGeneratePolicy numberGeneratePolicy;

    public RacingCarGame(Console console, MovingPolicy movingPolicy, NumberGeneratePolicy numberGeneratePolicy) {
        this.console = console;
        this.movingPolicy = movingPolicy;
        this.numberGeneratePolicy = numberGeneratePolicy;
    }

    public void run() {
        CarNames carNames = new CarNames(console.readCarNames());
        Round round = new Round(console.readNumberOfTrials());

        Cars cars = carNames.generateCars();
        console.printResultMessage();
        for (int i = 0; i < round.getRound(); i++) {
            cars = cars.playGame(movingPolicy, numberGeneratePolicy);
            List<Result> results = cars.getResults();
            console.print(results);
        }

    }

}
