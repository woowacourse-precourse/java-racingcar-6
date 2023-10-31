package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGame;
import racingcar.domain.random.DefaultRandomService;
import racingcar.domain.random.RandomNumberFactory;
import racingcar.domain.random.RandomService;
import racingcar.view.input.ConsoleService;
import racingcar.view.input.DefaultConsoleService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class ApplicationContext {

    public RacingGameController racingGameController() {
        return new RacingGameController(racingGame(), inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView(consoleService());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private RacingGame racingGame() {
        return new RacingGame(randomNumberFactory());
    }

    private RandomNumberFactory randomNumberFactory() {
        return new RandomNumberFactory(randomService());
    }

    private RandomService randomService() {
        return new DefaultRandomService();
    }

    public ConsoleService consoleService() {
        return new DefaultConsoleService();
    }
}
