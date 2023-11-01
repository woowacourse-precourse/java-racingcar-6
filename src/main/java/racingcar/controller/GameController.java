package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutView;
import java.util.List;
import java.util.Set;

public class GameController {
    private final GameService gameService = new GameService();
    
    public void run() {
        initGame();
        playGame();
        endGame();
    }

    private void initGame() {
        String inputCarNames = InputView.requestInputCarNames();
        Set<String> carNames = gameService.convertInputCarNamesToSet(inputCarNames);
        gameService.initGame(carNames);
    }

    private void playGame() {
        String inputTryCount = InputView.requestInputTryCount();
        int tryCount = gameService.convertInputTryCountToInt(inputTryCount);

        for(int i = 0; i < tryCount; i++) {
            gameService.playGame();
            OutView.printMoveResult(gameService.getCars());
        }
    }

    private void endGame() {
        List<Car> winners = gameService.getWinners();
        OutView.printWinners(winners);
    }
}
