package racingcar.controller;

import java.util.List;

import racingcar.util.StringUtil;
import racingcar.domain.Car;
import racingcar.dto.RacingResult;
import racingcar.factory.CarFactory;
import racingcar.application.RacingService;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;
    private final StringUtil converter;
    private final CarFactory carFactory;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService,
            StringUtil converter, CarFactory carFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
        this.converter = converter;
        this.carFactory = carFactory;
    }

    public void run() {
        List<Car> cars = createCars();
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

    private List<Car> createCars() {
        String carNames = inputView.inputCarNames();
        return carFactory.createCars(converter.convertToListByDelimiter(carNames));
    }

    private int createTryCount() {
        String tryCount = inputView.inputTryCount();
        return converter.convertToPositiveInt(tryCount);
    }
}
