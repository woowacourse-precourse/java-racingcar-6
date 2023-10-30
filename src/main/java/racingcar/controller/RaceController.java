package racingcar.controller;

import racingcar.model.PrintMessage;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RaceService raceService = new RaceService();

    public void run() {
        getInputs();
        playGame();
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
