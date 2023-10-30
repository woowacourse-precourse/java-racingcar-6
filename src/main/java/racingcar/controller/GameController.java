package racingcar.controller;

import java.util.List;
import racingcar.model.Game;
import racingcar.model.GameResult;
import racingcar.util.CarNamesSeperator;
import racingcar.util.GameTimeParser;
import racingcar.view.InputView;
import racingcar.view.OuputView;

public class GameController {
    private final Game game = new Game();

    public void run() {
        game.enrollCars(getCarNames());
        final int gameTime = getGameTime();
        runGame(gameTime);
        endGame();
    }

    private void runGame(int gameTime) {
        OuputView.ouputBeforeGameResult();
        for (int i = 0; i < gameTime; i++) {
            runRound();
        }
    }

    private void runRound() {
        game.playRound();
        printResult();
    }

    private void printResult() {
        List<GameResult> gameResultList = game.generateGameResultList();
        for (GameResult gameResult : gameResultList) {
            OuputView.ouputGameResult(gameResult);
        }
        OuputView.outputEmptyLine();
    }

    private void endGame() {
        List<String> winners = game.getWinnerCars();
        OuputView.ouputGameWinner(winners);
    }

    private int getGameTime() {
        String inputGameTime = InputView.inputGameTime();
        return GameTimeParser.parse(inputGameTime);
    }

    private List<String> getCarNames() {
        String carNames = InputView.inputCarName();
        return CarNamesSeperator.separate(carNames);
    }
}
