package racingcar.controller;

import racingcar.exception.GameException;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private Game game = new Game();
    private GameView gameView = new GameView();
    private GameException gameException = new GameException();

    public String[] splitInput(String input, String delimiter) {
        return input.split(delimiter);
    }
}
