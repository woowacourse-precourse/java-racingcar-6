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

    public RacingCarController(final OutputView outputView, final InputView inputView, final RacingCarService racingCarService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingCarService = racingCarService;
    }

    public void play() {
        final Cars cars = writeCarNames();
        final int repeatCount = writeRepeatNumber();
        printResultOfEachRun(cars, repeatCount);
        printWinner(cars);
    }

    private Cars writeCarNames() {
        outputView.printStartMessage();
        final String carName = inputView.readRacingCarName();
        final Cars cars = racingCarService.saveCarName(carName);
        return cars;
    }

    private int writeRepeatNumber() {
        outputView.printRepeatNumberMessage();
        final int repeatCount = Integer.parseInt(inputView.readRepeatCount());
        return repeatCount;
    }

    private void printResultOfEachRun(Cars cars, int repeatCount) {
        outputView.printGameStatusMessage();
        for (int i = 0; i < repeatCount; i++) {
            racingCarService.moveCar(cars);
            outputView.printGameStatus(cars);
        }
    }

    private void printWinner(Cars cars) {
        final ResultCars resultCars = cars.filterCarsWithMaxDistance();
        outputView.printRacingCarResult(resultCars);
    }
}
