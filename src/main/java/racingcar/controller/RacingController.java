package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private RacingService racingService;

    private final OutputView outputView;

    private final InputView inputView;

    private Integer tryNumber;

    public RacingController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void play() {
        start();
        tryNumber();
    }


    private void tryNumber() {
        outputView.outputTryNumberMessage();

        this.tryNumber = inputView.inputTryNumber();
    }

    private void start() {
        outputView.outputStartMessage();
        String carsName = inputView.inputCarsName();

        this.racingService = new RacingService(carsName);
        this.racingService.setOutputView(outputView);
    }
}
