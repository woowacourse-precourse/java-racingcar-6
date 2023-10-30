package racingcar.controller;

import racingcar.view.MainView;

public class RacingcarController {
    private static final RacingcarController instance = new RacingcarController();

    public static RacingcarController getInstance() {
        return instance;
    }

    private RacingcarController() {
    }

    public void run() {
        MainView.printStartMessage();
    }
}
