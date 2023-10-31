package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class RacingController {

    private final RacingService racingService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(RacingService racingService, InputView inputView, OutputView outputView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        start();

        play();

        printWinner();
    }

    private void start() {
        List<String> nameList = inputView.carNameInput();
        racingService.generateCar(nameList);
    }

    private void play() {
        String tryInput = inputView.tryInputNumber();

        List<String> moveResultList = racingService.playRace(tryInput);
        outputView.outputStep(moveResultList);
    }

    private void printWinner() {
        String winner = racingService.getWinner();
        outputView.outputWinner(winner);
    }
}
