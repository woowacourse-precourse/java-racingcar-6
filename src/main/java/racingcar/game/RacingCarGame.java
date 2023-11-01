package racingcar.game;

import racingcar.util.GameUtil;

public class RacingCarGame {
    private final GameUtil gameUtil;

    public RacingCarGame() {
        this.gameUtil = new GameUtil();
    }


    public void run() {
        gameUtil.initGame();
        System.out.println();

        while (!gameUtil.checkGameOver()) {
            gameUtil.startRound();
            gameUtil.showResults();
        }

        gameUtil.showWinners();
    }
}
