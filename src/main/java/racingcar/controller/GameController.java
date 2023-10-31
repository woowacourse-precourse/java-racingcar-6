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
        attempts = getAttemptsInput();
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

    private Attempts getAttemptsInput() {
        InputView.printAsking();
        //TODO: 리팩토링 포인트
        try {
            int attempts = Integer.parseInt(InputView.getUserInput());
            return new Attempts(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
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
