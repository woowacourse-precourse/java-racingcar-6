package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import racingcar.domain.Game;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private Game game;
    private int roundNum;
    Validator validator = new Validator();

    public void startGame() {
        setGameValues();
        play();
        OutputView.printWinners(game.getWinners());
    }

    public void setGameValues() {
        game = convertStringToList(InputView.carInput());
        roundNum = convertStringToInt(InputView.roundInput());
    }

    public void play() {
        OutputView.printStartGameMessage();
        for (int i = 0; i < roundNum; i++) {
            OutputView.printRoundResult(game.getRoundResult());
        }
    }

    public Game convertStringToList(String input) {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        validator.validate(carNames);
        return new Game(carNames);
    }

    public int convertStringToInt(String input) {
        validator.isInteger(input);
        return Integer.parseInt(input);
    }
}
