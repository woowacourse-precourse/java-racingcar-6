package racingcar.controller;

import java.util.List;

import static racingcar.view.GameInputView.inputAttemptCount;
import static racingcar.view.GameInputView.inputCarNames;

public class GameController {

    public void start() {
        List<String> carNames = inputCarNames();
        int attemptCount = inputAttemptCount();
    }
}
