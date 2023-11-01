package racingcar;

import racingcar.application.RandomMoveRule;
import racingcar.controller.ConsoleInputOutput;
import racingcar.domain.game.Game;
import racingcar.domain.game.GameOperator;
import racingcar.domain.policy.MoveRule;

public class Application {
    private static final MoveRule MOVE_RULE = new RandomMoveRule();
    private static final GameOperator gameOperator = new ConsoleInputOutput();

    public static void main(String[] args) {
        Game game = new Game(MOVE_RULE, gameOperator);

        String result = game.play();

        gameOperator.print(result);
    }
}
