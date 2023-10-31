package racingcar;

import racingcar.domain.GameController;
import racingcar.domain.MoveFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MoveFactory moveFactory = new MoveFactory(numberGenerator);
        GameController gameController = new GameController(moveFactory);
        gameController.start();
    }
}
