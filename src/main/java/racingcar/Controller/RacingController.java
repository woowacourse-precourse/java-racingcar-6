package racingcar.Controller;

import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    public RacingController() {
        inputView = new InputView();
    }

    public void startGame() {
        inputView.printInputCarName();
    }
}
