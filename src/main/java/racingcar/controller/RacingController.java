package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final RacingService racingService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(RacingService racingService, InputView inputView, OutputView outputView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carsName = inputView.getCarsName();
        racingService.saveCars(carsName);
        getAttempts();
    }

    private void getAttempts() {
        String attempts = inputView.getAttempts();
        racingService.saveAttempts(attempts);
        printResult();
    }

    private void printResult() {
        outputView.printResult();
        printMoveResult();
    }

    private void printMoveResult() {
        int attempts = racingService.findAttempt();
        for (int i=0; i<attempts; i++) {
            List<Car> cars = racingService.move();
            outputView.printMoveResult(cars);
        }
        printWinners();
    }

    private void printWinners() {
        List<Car> cars = racingService.findWinner();
        outputView.printWinners(cars);
    }
}
