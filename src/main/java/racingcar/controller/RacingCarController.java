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
        racingCarService.playRacingCar(attemptCount);
    }

    private void saveRacingCars(String carNames) {
        String[] racingCarsStr = racingCarService.splitRacingCarsByComma(carNames);
        racingCarService.saveRacingCars(racingCarsStr);
    }
}
