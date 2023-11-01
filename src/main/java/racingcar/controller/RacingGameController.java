package racingcar.controller;

import racingcar.Generator.NumberGenerator;
import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private OutputView output;
    private InputView input;

    public RacingGameController() {
        this.output = new OutputView();
        this.input = new InputView();
    }

    public void start() {
        output.askForAllCarNames();
        String allCarNames = input.getAllCarNames();
        CarList cars = new CarList(allCarNames);
        output.askForNumberOfRounds();
        int numberOfRounds = input.getNumberOfRounds();

        if (numberOfRounds > 0) {
            output.printRaceResultMessage();
            runRace(cars, numberOfRounds);
        }

    }

    public void runRace(CarList cars, final int numberOfRounds) {
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < numberOfRounds; i++) {
            runRound(cars, numberGenerator);
        }
        findRaceWinners(cars);
    }

    private void findRaceWinners(CarList cars) {
        int maxPosition = cars.findMaxPosition();
        List<String> winnerNames = cars.findWinners(maxPosition);
        output.printWinners(winnerNames);
    }

    private void runRound(CarList cars, NumberGenerator numberGenerator) {
        cars.doRound(numberGenerator);
        output.printRoundResult(cars);
    }
}
