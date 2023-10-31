package racingcar.controller;

import racingcar.domain.Attempts;
import racingcar.domain.Cars;
import racingcar.util.Parser;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;

public class GameController {
    private final RandomNumberGenerator generator;
    private Cars cars;
    private Attempts attempts;

    public GameController() {
        generator = new RandomNumberGenerator();
    }

    public void run() {
        String input = getCarsInput();
        parseInputToCars(input);
        InputView.printAsking();
        parseInputToAttempts(InputView.getUserInput());
        play(attempts);
        showResult();
    }

    private String getCarsInput() {
        InputView.printStart();
        return InputView.getUserInput();
    }

    private void parseInputToCars(String input) {
        cars = Parser.parseStringToCars(input);
    }

    private void parseInputToAttempts(String input) {
        attempts = Parser.parseStringToAttempts(input);
    }

    private void play(Attempts attempts) {
        InputView.printResult();
        while (attempts.isNotZero()) {
            this.cars = cars.simulateNextRound(generator);
            InputView.printCurrentCarLocation(cars);
            attempts.minusAttempts();
        }
    }

    private void showResult() {
        InputView.printWinners(cars.getWinners());
    }

}
