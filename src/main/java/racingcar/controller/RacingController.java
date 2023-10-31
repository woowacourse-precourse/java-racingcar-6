package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

    private RacingController() {}

    private static class RacingControllerCreater {
        private static final RacingController INSTANCE = new RacingController();
    }

    public static RacingController getInstance() {
        return RacingControllerCreater.INSTANCE;
    }

    private final static InputView inputView = InputView.getInstance();

    public void startGame() {
        inputView.startGame();
    }
}
