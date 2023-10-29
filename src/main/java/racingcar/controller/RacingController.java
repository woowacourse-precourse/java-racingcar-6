package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingService = new RacingService();
    }

    public void startRacing() {
        String carNames = inputView.inputCarNames();
        saveRacingCars(carNames);

        int attemptCount = Integer.parseInt(inputView.inputAttemptCounts());
        playRacing(attemptCount);

        outputView.printWinners(racingService.getWinnerNames());
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
}
