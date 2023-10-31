package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.io.input.InputManager;
import racingcar.io.input.InputMapper;
import racingcar.io.input.InputView;
import racingcar.io.output.OutputView;
import racingcar.model.MovingCondition;
import racingcar.service.RacingCarService;

public class RacingCarFactory {

    public RacingCarController racingCarController() {
        return new RacingCarController(inputManager(), outputView(), racingCarService());
    }

    private RacingCarService racingCarService() {
        return new RacingCarService(movingCondition());
    }

    private MovingCondition movingCondition() {
        return new MovingCondition();
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
