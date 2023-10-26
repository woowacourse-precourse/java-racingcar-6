package racingcar.controller;

import racingcar.domain.Garage;
import racingcar.domain.TryCount;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public GameController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void playGame() {
        Garage garage = inputView.getInputCarNames();
        TryCount tryCount = inputView.getTryCount();
        racingService.race(garage);

    }
}
