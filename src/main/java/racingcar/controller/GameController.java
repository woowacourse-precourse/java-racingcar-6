package racingcar.controller;

import static racingcar.view.InputView.printResult;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.view.InputView;

public class GameController {
    private final GameService gameService;
    private Cars cars;

    public GameController() {
        gameService = new GameService();
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
        while (attempts != 0) {
            attempts--;
        }
    }

    private void showResult() {
        InputView.printResult();
    }






}
