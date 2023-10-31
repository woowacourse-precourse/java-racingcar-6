package racingcar;

import racingcar.controller.Parser;
import racingcar.controller.RacingController;
import racingcar.model.CarRepository;
import racingcar.model.Generator;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRepository carRepository = new CarRepository();
        Generator generator = new Generator();
        RacingService racingService = new RacingService(carRepository, generator);

        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RacingController controller = new RacingController(racingService, inputView, outputView);

        controller.run();
    }
}
