package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {
    private RacingService racingService;
    private InputView inputView = new InputView();

    public RacingController() {
        Cars cars = new Cars(inputView.createRacingCar());
        int racingCount = inputView.getRacingCount();
        racingService = new RacingService(cars, racingCount);
    }

    public void run() {
        racingService.startRacing();
        racingService.getRacingResult();
    }
}
