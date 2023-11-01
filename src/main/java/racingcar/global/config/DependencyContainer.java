package racingcar.global.config;

import racingcar.domain.controller.MainController;
import racingcar.domain.service.GameService;
import racingcar.global.util.Validator;
import racingcar.domain.view.InputView;
import racingcar.domain.view.OutputView;

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
