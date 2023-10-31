package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.GameException;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private Game game = new Game();
    private GameView gameView = new GameView();
    private GameException gameException = new GameException();

    public void requestInputCarNames() {
        gameView.printCarNameInputPhrase();
        generateCar(splitInput(Console.readLine(), game.getDELIMITER()));
    }
    public String[] splitInput(String input, String delimiter) {
        return input.split(delimiter);
    }

    public void generateCar(String[] names) {
        for (String name : names) {
            gameException.checkNameLength(name);
            game.addCarList(name);
        }
    }

    public void requestInputTry() {
        gameView.printTryNumPhrase();
        game.setUserTry(gameException.checkInput(Console.readLine()));
    }

    public void requestPrintResult() {
        gameView.printResultPhrase();
        for (int i = 0; i < game.getUserTry(); i++) {
            game.moveCars();
            gameView.printCarResult(game);
        }
    }

    public void requestPrintWinner() {
        gameView.printWinner(game.getWinnerList());
    }
}
