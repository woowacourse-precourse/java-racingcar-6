package racingcar.controller;

import racingcar.view.ConsoleView;

public class GameController {
    private ConsoleView view;

    public GameController() {
        view = new ConsoleView();
    }

    public void runGame() {
        CarList carList = new CarList();
        TryInput tryInput = new TryInput();
    }
}
