package racingcar.controller;

import java.util.stream.IntStream;
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

        gamePlay();

        outputView.outputFinishMessage();
        String result = getWinnersList();
        outputView.outputWinners(result);
    }

    private String getWinnersList() {
        return racingService.getListToStringWinners();
    }

    private void gamePlay() {
        outputView.outputResultMessage();
        IntStream.range(0, this.tryNumber)
                .forEach(i -> racingService.racingStart());
    }

    private void tryNumber() {
        outputView.outputTryNumberMessage();

        this.tryNumber = inputView.inputTryNumber();
    }

    private void start() {
        outputView.outputStartMessage();
        String carsName = inputView.inputCarsName();

        this.racingService = new RacingService(carsName);
        this.racingService
                .setOutputView(outputView);
    }
}
