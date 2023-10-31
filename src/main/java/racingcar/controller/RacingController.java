package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private RacingService racingService;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public RacingController() {
        Cars cars = new Cars(inputView.createRacingCar());
        String racingCount = inputView.getRacingCount();
        racingService = new RacingService(cars, racingCount);
    }

    public void run() {
        startRacing();
        endRacing();
    }

    private void startRacing() {
        outputView.printRacingResult();

        while (racingService.isPlayRacing()) {
            racingService.playRacing();
            outputView.printMoveResult(racingService.getCars());
        }
    }

    private void endRacing() {
        outputView.printRacingWinner(racingService.getCars());
    }
}
