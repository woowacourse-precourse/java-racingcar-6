package racingcar.controller;

import racingcar.model.GameModel;
import racingcar.utils.InputValidator;
import racingcar.view.ConsoleView;

public class GameController {
    private GameModel gameModel;
    private ConsoleView consoleView;

    public GameController(ConsoleView consoleView, GameModel gameModel) {
        this.consoleView = consoleView;
        this.gameModel = gameModel;
    }

    public void start() {
        consoleView.printStartMessage();
        String inputCars = consoleView.readInput();
        String[] carNames = inputCars.split(",");

        //검증
        InputValidator.validateCarNames(carNames);

        consoleView.printTryCountMessage();
        int tryCount = Integer.parseInt(consoleView.readInput());

        //검증
        InputValidator.validateTryCount(tryCount);

        gameModel = new GameModel(carNames, tryCount);
        consoleView.printResultMessage();
        while (!gameModel.isGameEnd()) {
            gameModel.moveCars();
            consoleView.printCurrentState(gameModel.getCars());
        }
        consoleView.printWinner(gameModel.getWinners());

    }


}
