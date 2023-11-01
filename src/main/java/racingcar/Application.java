package racingcar;

import racingcar.domain.car.RandomMove;
import racingcar.domain.car.RandomUtil;
import racingcar.domain.game.generator.ExecutionResultGenerator;
import racingcar.domain.game.controller.GameController;
import racingcar.domain.game.generator.WinningResultGenerator;

import static racingcar.global.exception.ExceptionMessage.ERROR_PREFIX;

public class Application {
    public static void main(String[] args) {
        RandomUtil randomUtil = new RandomMove();
        ExecutionResultGenerator executionResultGenerator = new ExecutionResultGenerator();
        WinningResultGenerator winningResultGenerator = new WinningResultGenerator();

        try {
            GameController gameController = new GameController(randomUtil, executionResultGenerator, winningResultGenerator);
            gameController.playGame();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + e.getMessage());
        }
    }
}
