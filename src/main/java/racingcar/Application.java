package racingcar;

import racingcar.application.RandomDriveRule;
import racingcar.controller.ConsoleInputOutput;
import racingcar.domain.game.Game;
import racingcar.domain.game.GameOperator;
import racingcar.domain.policy.DriveRule;

public class Application {
    private static final DriveRule driveRule = new RandomDriveRule();
    private static final GameOperator gameOperator = new ConsoleInputOutput();

    public static void main(String[] args) {
        Game game = new Game(driveRule, gameOperator);

        String result = game.run();

        gameOperator.print(result);
    }
}
