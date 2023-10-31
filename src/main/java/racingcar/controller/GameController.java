package racingcar.controller;

import racingcar.domain.Attempts;
import racingcar.domain.Cars;
import racingcar.util.Parser;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final RandomNumberGenerator generator;
    private Cars cars;
    private Attempts attempts;

    public GameController(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public void run() {
        InputView.printStart();
        parseInputToCars(InputView.getUserInput());
        InputView.printAskingAttempts();
        parseInputToAttempts(InputView.getUserInput());
        play(attempts);
        showResult();
    }

    private void parseInputToCars(String input) {
        cars = Parser.parseStringToCars(input);
    }

    private void parseInputToAttempts(String input) {
        attempts = Parser.parseStringToAttempts(input);
    }

    private void play(Attempts attempts) {
        OutputView.printResult();
        while (attempts.isNotZero()) {
            this.cars = cars.simulateNextRound(generator);
            OutputView.printCurrentCarLocation(cars);
            attempts.minusAttempts();
        }
    }

    private void showResult() {
        OutputView.printWinners(cars.getWinners());
    }

}
