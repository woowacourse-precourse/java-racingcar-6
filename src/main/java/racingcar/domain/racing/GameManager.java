package racingcar.domain.racing;

import java.util.List;
import racingcar.controller.RacingCarController;
import racingcar.domain.car.CarManager;
import racingcar.domain.winner.WinnerChecker;
import racingcar.view.GameView;

public class GameManager {
    private CarManager carManager;
    private GameRoundManager gameRoundManager;
    private WinnerChecker winnerChecker;
    private final RacingCarController racingCarController;
    private final RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
    private final GameView gameView = new GameView();

    public GameManager() {
        this.racingCarController = new RacingCarController(gameView);
    }

    public void playGame(int rounds) {
        gameRoundManager = new GameRoundManager(carManager.getCars());
        winnerChecker = new WinnerChecker(carManager.getCars());
        for (int i = 0; i < rounds; i++) {
            gameRoundManager.playRound();
            gameView.printRoundResult(carManager.getCars());
        }
        List<String> winners = winnerChecker.findWinners();
        gameView.printWinner(winners);
    }

    public void gameStart() {
        String carNames = racingCarController.getUserInputForCarNames();
        int rounds = racingCarController.getUserInputForRounds();
        carManager = new CarManager(carNames, randomMoveStrategy);
        playGame(rounds);
    }
}