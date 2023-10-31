package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.RacingService;
import racingcar.controller.RacingController;
import racingcar.factory.CarFactory;
import racingcar.generator.RandomNumberGenerator;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView(new InputValidator());
        final OutputView outputView = new OutputView();
        final RacingService racingService = new RacingService(new RandomNumberGenerator());
        final CarFactory carFactory = new CarFactory();
        final RacingController racingController = new RacingController(inputView, outputView, racingService, carFactory);

        racingController.run();
        Console.close();
    }
}
