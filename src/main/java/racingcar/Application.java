package racingcar;

import racingcar.controller.Controller;
import racingcar.controller.GameInitializer;
import racingcar.controller.GameRunner;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomNumberGenerator);
        GameInitializer gameInitializer = new GameInitializer(inputView, outputView);
        GameRunner gameRunner = new GameRunner(outputView, randomMoveStrategy);

        Controller controller = new Controller(inputView, outputView, gameInitializer, gameRunner);
        controller.run();
    }
}