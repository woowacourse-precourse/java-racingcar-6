package racingcar;

import racingcar.controller.Controller;
import racingcar.controller.GameRunner;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        GameRunner gameRunner = new GameRunner(outputView, randomNumberGenerator, randomMoveStrategy);

        Controller controller = new Controller(inputView, outputView, gameRunner);
        controller.run();
    }
}