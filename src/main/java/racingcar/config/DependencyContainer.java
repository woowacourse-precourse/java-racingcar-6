package racingcar.config;

import racingcar.controller.MainController;
import racingcar.service.GameService;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class DependencyContainer {
    private final MainController mainController;

    public DependencyContainer() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();
        Validator validator = new Validator();
        this.mainController = createMainController(inputView, outputView, gameService, validator);
    }

    private MainController createMainController(InputView inputView, OutputView outputView, GameService gameService, Validator validator) {
        return new MainController(inputView, outputView, gameService, validator);
    }

    public MainController getMainController() {
        return mainController;
    }
}
