package racingcar.controller;

import java.util.List;
import racingcar.model.GameResult;
import racingcar.service.GameService;
import racingcar.util.CarNamesSeperator;
import racingcar.util.GameTimeParser;
import racingcar.view.InputView;
import racingcar.view.OuputView;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        gameService.enrollCars(getCarNames());
        final int gameTime = getGameTime();

        OuputView.ouputBeforeGameResult();

        for (int i = 0; i < gameTime; i++) {
            runRound();
            OuputView.outputEmptyLine();
        }
        List<String> winners = gameService.getWinners();
        OuputView.ouputGameWinner(winners);
    }

    private void runRound() {
        List<GameResult> gameResultList = gameService.runGame();
        for (GameResult gameResult : gameResultList) {
            OuputView.ouputGameResult(gameResult);
        }
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
