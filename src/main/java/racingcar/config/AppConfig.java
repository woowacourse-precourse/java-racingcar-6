package racingcar.config;

import racingcar.controller.GameController;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.util.ConsoleInputUtil;
import racingcar.util.GameConsoleInputUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public GameController config() {
        ConsoleInputUtil consoleInputUtil = consoleInputUtil();
        InputView inputView = inputView(consoleInputUtil);
        OutputView outputView = outputView();
        CarRepository carRepository = new CarRepository();
        GameService gameService = gameService(carRepository);

        return gameController(inputView, outputView, gameService);
    }

    private ConsoleInputUtil consoleInputUtil() {
        return new GameConsoleInputUtil();
    }

    private InputView inputView(ConsoleInputUtil consoleInputUtil) {
        return new InputView(consoleInputUtil);
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private CarRepository carRepository() {
        return new CarRepository();
    }

    private GameService gameService(CarRepository carRepository) {
        return new GameService(carRepository);
    }

    private GameController gameController(InputView inputView, OutputView outputView, GameService gameService) {
        return new GameController(inputView, outputView, gameService);
    }
}
