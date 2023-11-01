package racingcar.domain.game;

import static racingcar.constant.CommonConstant.ONE_BLANK_LINE;
import static racingcar.constant.GameConstant.INITIAL_START_ROUND;

import racingcar.dto.Round;
import racingcar.view.OutputView;

public class GameManager {
    public static Integer totalRounds = 0;
    private GameEngine gameEngine;

    public GameManager() {
        gameEngine = new GameEngine();
    }

    public void startGame() {
        GameRound gameRound = new GameRound(new Round(INITIAL_START_ROUND));

        while (gameRound.getCurrentRound() < totalRounds) {
            gameRound.passCurrentRound();
            gameEngine.processTurn();
            OutputView.printBlankLine(ONE_BLANK_LINE);
        }
        
        OutputView.printGameWinner(gameEngine.findWinner());
    }

    public void saveTotalRoundOfGame(Integer round) {
        totalRounds = round;
    }
}