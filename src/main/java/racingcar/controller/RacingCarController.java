package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService = new RacingCarService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private int attemptNumber = 0;

    public void playGame() {
        initialize();
        play();
        findWinner();
    }

    private void initialize() {
        racingCarService.createCars(inputView.inputCars());
        attemptNumber = Integer.parseInt(inputView.inputAttemptNumber());
    }

    private void play() {
        outputResultMessage();

        for (int i = 0; i < attemptNumber; i++) {
            racingCarService.moveCars();
            outputMoveResult();
            outputView.outputLineBreak();
        }
    }

    private void outputResultMessage() {
        outputView.outputResultMessage();
    }

    private void findWinner() {
        outputView.outputWinner(racingCarService.outputWinner());
    }

    private void outputMoveResult() {
        int carsCount = racingCarService.countCars();

        for (int i = 0; i < carsCount; i++) {
            Car car = racingCarService.getCar(i);
            outputView.outputResult(car.getName(), car.getDistance());
        }
    }
}
