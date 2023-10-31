package racingcar.configuration;

import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingGameRepository;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public interface Config {
    CarRepository carRepository();

    RacingGameRepository racingRepository();

    CarService carService();

    RacingGameService racingService();

    InputView inputView();

    OutputView outputView();

    RacingGameController racingController();
}
