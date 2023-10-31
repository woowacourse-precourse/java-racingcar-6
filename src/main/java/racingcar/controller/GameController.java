package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.io.Input;
import racingcar.io.OutPut;
import racingcar.service.GameService;

public class GameController {
    private static final String EXECUTION_RESULT = "실행 결과";
    private RacingGame racingGame;

    public void run() {
        initGame();
        playGame();
        endGame();
    }

    private void initGame() {
        List<String> names = Input.carNames();
        int finalRound = Input.gameRound();
        this.racingGame = new RacingGame(finalRound, names);
    }

    private void playGame() {
        System.out.println(EXECUTION_RESULT);
        while (!racingGame.isFinalRound()) {
            GameService.playSingleRound(racingGame);
            OutPut.resultSingleRound(racingGame);
        }
    }

    private void endGame() {
        List<Car> winners = GameService.getWinners(racingGame.getCars());
        OutPut.winner(winners);
    }
}
