package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.io.InputManager;
import racingcar.io.InputMapper;
import racingcar.io.InputValidator;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class ComponentFactory {

    public RacingCarController racingCarController() {
        return new RacingCarController(outputView(), inputManager());
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputMapper());
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
