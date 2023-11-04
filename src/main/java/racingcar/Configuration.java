package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.domain.validate.CarNameValidator;
import racingcar.domain.validate.TryNumberValidator;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Configuration {
    public static RacingCarService racingCarService() {
        return new RacingCarService(new Cars());
    }

    public static RacingCarController racingCarController() {
        return new RacingCarController(
                new InputView(),
                new OutputView(),
                new CarNameValidator(),
                new TryNumberValidator(),
                racingCarService());
    }
}
