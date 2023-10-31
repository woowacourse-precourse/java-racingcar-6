package racingcar;

import racingcar.domain.car.RandomMove;
import racingcar.domain.car.RandomUtil;
import racingcar.domain.game.ExecutionResultGenerator;
import racingcar.domain.game.controller.GameController;
import racingcar.domain.game.WinningResultGenerator;

public class Application {
    public static void main(String[] args) {
        RandomUtil randomUtil = new RandomMove();
        ExecutionResultGenerator executionResultGenerator = new ExecutionResultGenerator();
        WinningResultGenerator winningResultGenerator = new WinningResultGenerator();

        GameController gameController = new GameController(randomUtil, executionResultGenerator, winningResultGenerator);

        gameController.playGame();
    }
}
