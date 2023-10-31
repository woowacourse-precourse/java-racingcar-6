package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.CarManager;
import racingcar.domain.winner.WinnerChecker;

public class GameManager {
    private final CarManager carManager;
    private final GameRoundManager gameRoundManager;
    private final WinnerChecker winnerChecker;
    private final RandomMoveStrategy randomMoveStrategy= new RandomMoveStrategy();

    public GameManager(String carNames) {
        this.carManager = new CarManager(carNames,randomMoveStrategy);
        this.gameRoundManager = new GameRoundManager(carManager.getCars());
        this.winnerChecker = new WinnerChecker(carManager.getCars());
    }

    public void playGame(int rounds) {
        for (int i = 0; i < rounds; i++) {
            gameRoundManager.playRound();
        }

        List<String> winners = winnerChecker.findWinners();
    }
}