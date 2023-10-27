package racingcar.controller;

import racingcar.view.UserInputValue;

public class RaceController {
    public RaceController() {
    }

    public void startRace() {
        UserInputValue.inputCarName();
        UserInputValue.inputMovementCount();
    }
}
