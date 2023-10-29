package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        inputView = new InputView();
        racingCarService = new RacingCarService();
    }

    public void startRacing() {
        String carNames = inputView.inputCarNames();
        saveRacingCars(carNames);

        int attemptCount = Integer.parseInt(inputView.inputAttemptCounts());
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            racingCarService.playOneRacing();
        }
    }

    private void saveRacingCars(String carNames) {
        String[] racingCarsStr = racingCarService.splitRacingCarsByComma(carNames);
        racingCarService.saveRacingCars(racingCarsStr);
    }
}
