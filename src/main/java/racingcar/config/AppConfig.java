package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.io.input.InputManager;
import racingcar.io.input.InputMapper;
import racingcar.io.input.InputView;
import racingcar.io.output.OutputView;
import racingcar.model.MovingCondition;
import racingcar.model.RacingCarMovingCondition;
import racingcar.service.CarService;
import racingcar.service.RacingCarService;

public class AppConfig {

    public RacingCarController racingCarController() {
        return new RacingCarController(inputManager(), outputView(), racingCarService());
    }

    private CarService racingCarService() {
        return new RacingCarService(movingCondition());
    }

    private MovingCondition movingCondition() {
        return new RacingCarMovingCondition();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputMapper());
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private InputView inputView() {
        return new InputView();
    }
}
