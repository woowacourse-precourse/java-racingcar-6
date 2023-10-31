package racingcar.controller;

import racingcar.model.PrintMessage;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void run() {
        getInputs();
        playGame();
    }

    private String calculateWinners() {
        return raceService.calculateWinners();
    }

    private void playGame() {
        print(PrintMessage.RESULT);
        while (!raceService.isEnd()) {
            print(raceService.playOneRound());
        }
    }

    private void getInputs() {
        getCarList();
        getTryNumber();
    }

    private void getTryNumber() {
        print(PrintMessage.GET_TRY_COUNT);
        raceService.makeTryNumber(inputView.input());
    }

    private void getCarList() {
        print(PrintMessage.GET_CAR_NAME);
        raceService.makeCarList(inputView.input());
    }

    private void print(String message) {
        outputView.printMessage(message);
    }

    private void print(PrintMessage message) {
        outputView.printMessage(message);
    }
}
