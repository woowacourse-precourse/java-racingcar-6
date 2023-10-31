package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.dto.ResultCars;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView;
    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingCarService = new RacingCarService();
    }

    public void play() {
        outputView.printStartMessage();
        final String carName = inputView.readRacingCarName();
        final Cars cars = racingCarService.saveCarName(carName);
        outputView.printRepeatNumberMessage();
        final String repeatCount = inputView.readRepeatCount();
        outputView.printGameStatusMessage();
        for (int i = 0; i < Integer.parseInt(repeatCount); i++) {
            racingCarService.moveCar(cars);
            outputView.printGameStatus(cars);
        }
        final ResultCars resultCars = cars.filterCarsWithMaxDistance();
        outputView.printRacingCarResult(resultCars);
    }
}
