package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.domain.CarManager;
import racingcar.util.RacingGuideMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {

    InputView inputView;
    OutputView outputView;
    CarManager carManager;

    public Race() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carManager = new CarManager();
    }

    public void start() {
        CarGroup carGroup = carManager.createCarList(inputCarNames());
    }

    private String inputCarNames() {
        outputView.showMessage(RacingGuideMessage.INPUT_CAR_NAMES);
        return inputView.getUserInput();
    }
}
