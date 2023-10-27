package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Controller controller = new Controller(randomNumberGenerator, randomMoveStrategy, inputView, outputView);
        controller.run();
    }
}
