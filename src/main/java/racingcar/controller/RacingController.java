package racingcar.controller;

import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingModel racingModel;

    public RacingController(InputView inputView, OutputView outputView, RacingModel racingModel) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingModel = racingModel;
    }

    public void startRacing() {
        outputView.printStarting();
        racingModel.setPlayers(inputView.inputPlayers());
        outputView.printTimes();
        racingModel.setNumber_of_times(inputView.inputTimes());
        outputView.printRacing(racingModel);
    }

}
