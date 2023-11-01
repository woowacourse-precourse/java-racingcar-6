package racingcar.controller;

import racingcar.domain.CarGarage;
import racingcar.domain.TryCount;
import racingcar.domain.Winner;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        CarGarage carGarage = inputView.getCars();
        TryCount count = inputView.getTryCount();

        raceCar(count, carGarage);

        Winner winner = carGarage.findWinner();
        outputView.printWinner(winner);
    }

    private void raceCar(TryCount count, CarGarage carGarage) {
        outputView.printResultMessage();
        for (int i = 0; i < count.value(); i++) {
            racingService.race(carGarage);
            outputView.printRaceResult(carGarage);
        }
    }
}
