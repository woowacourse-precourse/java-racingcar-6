package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private final OutputView outputView;
    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingCarService = new RacingCarService();
    }

    public void play() {
        outputView.printStartMessage();
        String carName = inputView.readRacingCarName();
        racingCarService.saveCarName(carName);
        outputView.printRepeatNumberMessage();
        String repeatCount = inputView.readRepeatCount();
        racingCarService.moveCar(repeatCount);
    }
}
