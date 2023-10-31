package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.Parser;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;

public class GameController {
    private final RandomNumberGenerator generator;
    private Cars cars;

    public GameController() {
        generator = new RandomNumberGenerator();
    }

    public void run() {
        String input = getCarsInput();
        parseInputToCars(input);
        int attempts = getAttemptsInput();
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

    private int getAttemptsInput() {
        InputView.printAsking();
        return Integer.parseInt(InputView.getUserInput());
    }

    private void play(int attempts) {
        InputView.printResult();
        while (attempts != 0) {
            this.cars = cars.simulateNextRound(generator);
            InputView.printCurrentCarLocation(cars);
            attempts--;
        }
    }

    private void showResult() {
        InputView.printWinners(cars.getWinners());
    }

}
