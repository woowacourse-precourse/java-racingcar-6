package racingcar.configuration;

import racingcar.controller.RacingController;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingRepository;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public interface Config {
    CarRepository carRepository();

    RacingRepository racingRepository();

    CarService carService();

    RacingService racingService();

    InputView inputView();

    OutputView outputView();

    RacingController racingController();
}
