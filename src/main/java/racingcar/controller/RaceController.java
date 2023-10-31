package racingcar.controller;


import racingcar.enums.InputMessage;
import racingcar.view.OutputView;

public class RaceController {
    private final OutputView outputView;

    public RaceController() {
        this.outputView = new OutputView();
    }

    public void startGame() {
        String carNames = getCarNames();
    }

    private String getCarNames() {
        outputView.printMessage(InputMessage.INPUT_CAR_NAME_MESSAGE.getValue());
        return null;
    }
}
