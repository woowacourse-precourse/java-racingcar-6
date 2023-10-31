package racingcar.controller;

import racingcar.domain.dto.TotalRacingResult;
import racingcar.service.CarRacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {

    private final CarRacingService carRacingService;

    public CarRacingController() {
        carRacingService = new CarRacingService();
    }

    public void run() {
        String carsName = InputView.inputCarsNameView();
        int attemptNumber = InputView.inputAttemptNumberView();

        TotalRacingResult totalRacingResult = carRacingService.race(carsName, attemptNumber);

        OutputView.printRacingResult(totalRacingResult.getTotalCarsStatus());
        OutputView.printRacingWinner(totalRacingResult.getWinners());

    }

}
