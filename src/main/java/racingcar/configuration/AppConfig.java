package racingcar.configuration;

import racingcar.controller.RacingController;
import racingcar.domain.CarRepository;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public CarRepository carRepository() {
        return new CarRepository();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RacingService racingService() {
        return new RacingService(carRepository());
    }

    public RacingController racingController() {
        return new RacingController(inputView(), outputView(), racingService());
    }
}
