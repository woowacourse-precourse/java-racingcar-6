package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        inputView = new InputView();
        outputView = new OutputView();
        this.racingService =racingService;
    }

    public void startRacing() {
        receiveRacingCar();
        receiveAttemptCount();
        printWinner();
    }

    private void receiveRacingCar() {
        String carNames = inputView.inputCarNames();
        saveRacingCars(carNames);
    }

    private void receiveAttemptCount() {
        int attemptCount = Integer.parseInt(inputView.inputAttemptCounts());
        playRacing(attemptCount);
    }

    private void playRacing(int attemptCount) {
        outputView.printResultMessage();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            racingService.playOneRacing();
            outputView.printRacingResult(racingService.getRacingCars());
        }
    }

    private void saveRacingCars(String carNames) {
        String[] racingCarsStr = racingService.splitRacingCarsByComma(carNames);
        racingService.saveRacingCars(racingCarsStr);
    }

    private void printWinner() {
        outputView.printWinners(racingService.getWinnerNames());
    }
}
