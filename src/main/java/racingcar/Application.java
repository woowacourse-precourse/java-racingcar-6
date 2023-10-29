package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;
import racingcar.util.StringUtil;
import racingcar.factory.CarFactory;
import racingcar.generator.RandomNumberGenerator;
import racingcar.application.RacingService;
import racingcar.validator.InputValidator;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView(new InputValidator());
        final OutputView outputView = new OutputView();
        final StringUtil converter = new StringUtil();
        final RacingService racingService = new RacingService(new RandomNumberGenerator());
        final CarFactory carFactory = new CarFactory();
        final RacingController racingController = new RacingController(inputView, outputView, racingService, converter,
                carFactory);

        racingController.run();
        Console.close();
    }
}
