package racingcar.controller;

import racingcar.model.Message;
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
        outputView.printMessage(Message.SET_CAR_NAME);
        raceService.CarList(inputView.input());
        getCount();
    }

    private void getCount() {
        outputView.printMessage(Message.SET_TRY_COUNT);
        raceService.getTryCount(inputView.input());
    }
}
