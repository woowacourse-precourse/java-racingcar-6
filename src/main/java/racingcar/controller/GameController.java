package racingcar.controller;

import java.util.List;
import racingcar.model.car.dto.GameResult;
import racingcar.model.game.Game;
import racingcar.util.CarNamesSeperator;
import racingcar.util.GameTimeParser;
import racingcar.view.InputView;
import racingcar.view.OuputView;

public class GameController {
    public void run() {
        List<String> carNames = getCarNames();
        int gameTime = getGameTime();

        final Game game = new Game(gameTime, carNames);
        runGame(game);
        endGame(game);
    }

    private void runGame(final Game game) {
        OuputView.ouputBeforeGameResult();
        while (game.isGameNotEnded()) {
            game.playGame();
            printResult(game);
        }
    }

    private void printResult(final Game game) {
        List<GameResult> gameResultList = game.generateGameResultList();
        for (GameResult gameResult : gameResultList) {
            OuputView.ouputGameResult(gameResult);
        }
        OuputView.outputEmptyLine();
    }

    private void endGame(final Game game) {
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
