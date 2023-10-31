package racingcar.controller;

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
    }

    public void setGameValues() {
        game = validator.convertStringToList(InputView.carInput());
        roundNum = validator.convertStringToInt(InputView.roundInput());
    }

    public void play() {
        for (int i = 0; i < roundNum; i++) {
            OutputView.printRoundResult(game.getRoundResult());
        }
    }
}
