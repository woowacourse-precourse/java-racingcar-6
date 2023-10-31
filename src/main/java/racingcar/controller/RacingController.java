package racingcar.controller;

import racingcar.application.RacingService;
import racingcar.domain.Cars;
import racingcar.dto.RacingResult;
import racingcar.factory.CarFactory;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.StringUtil;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;
    private final CarFactory carFactory;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService,
                            CarFactory carFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
        this.carFactory = carFactory;
    }

    public void run() {
        Cars cars = createCars();
        int tryCount = createTryCount();

        outputView.printResultMessage();
        while (tryCount > 0) {
            List<RacingResult> racingResults = racingService.race(cars);
            outputView.printRacingResult(racingResults);
            tryCount--;
        }
        List<String> winners = racingService.selectWinners(cars);
        outputView.printWinners(winners);
    }

    private Cars createCars() {
        String carNames = inputView.inputCarNames();
        return carFactory.createCars(StringUtil.convertToListByDelimiter(carNames));
    }

    private int createTryCount() {
        String tryCount = inputView.inputTryCount();
        return StringUtil.convertToPositiveInt(tryCount);
    }
}
