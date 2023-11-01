package racingcar.domain.racing;

import java.util.List;
import racingcar.controller.RacingCarController;
import racingcar.domain.car.CarManager;
import racingcar.domain.util.RandomMoveStrategy;
import racingcar.domain.winner.WinnerChecker;
import racingcar.view.GameView;

public class GameManager {
    private CarManager carManager;
    private GameRoundManager gameRoundManager;
    private WinnerChecker winnerChecker;
    private final GameView gameView = new GameView();
    private final RacingCarController racingCarController = new RacingCarController(gameView);
    private final RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

    public void gameStart() {
        String carNames = racingCarController.getUserInputForCarNames();
        int rounds = racingCarController.getUserInputForRounds();

        setInstance(carNames);
        playGame(rounds);
    }

    private void playGame(int rounds) {
        for (int i = 0; i < rounds; i++) {
            gameRoundManager.playRound();
        }

        List<String> winners = winnerChecker.findWinners();
        gameView.printWinner(winners);
    }

    private void setInstance(String carNames) {
        carManager = new CarManager(carNames, randomMoveStrategy);
        gameRoundManager = new GameRoundManager(carManager.getCars(), gameView);
        winnerChecker = new WinnerChecker(carManager.getCars());
    }
}