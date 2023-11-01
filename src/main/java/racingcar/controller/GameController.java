package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.GameException;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private Game game = new Game();
    private GameException gameException = new GameException();

    public void startGame() {
        requestInputCarNames();
        requestInputTry();
        requestPrintResult();
        requestPrintWinner();
    }

    public void requestInputCarNames() {
        GameView.printCarNameInputPhrase();
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
        GameView.printTryNumPhrase();
        game.setUserTry(gameException.checkInput(Console.readLine()));
    }

    public void requestPrintResult() {
        GameView.printResultPhrase();
        for (int i = 0; i < game.getUserTry(); i++) {
            game.moveCars();
            GameView.printCarResult(game);
        }
    }

    public void requestPrintWinner() {
        GameView.printWinner(game.getWinnerList());
    }
}
