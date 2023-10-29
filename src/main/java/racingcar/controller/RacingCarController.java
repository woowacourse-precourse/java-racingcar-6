package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingCarService = new RacingCarService();
    }

    public void startRacing() {
        String carNames = inputView.inputCarNames();
        saveRacingCars(carNames);

        int attemptCount = Integer.parseInt(inputView.inputAttemptCounts());

        outputView.printResultMessage();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            racingCarService.playOneRacing();

            List<RacingCar> racingCars = racingCarService.getRacingCars();
            outputView.printRacingResult(racingCars);
        }
    }

    private void saveRacingCars(String carNames) {
        String[] racingCarsStr = racingCarService.splitRacingCarsByComma(carNames);
        racingCarService.saveRacingCars(racingCarsStr);
    }
}
