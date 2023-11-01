package racingcar.controller;

import racingcar.model.User;

public class GameController {
    private final User user = new User();

    public void startNewGame() {
        user.getUserInputForTryCount();
    }
}
