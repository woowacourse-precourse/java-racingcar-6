package racingcar.controller;

import racingcar.model.RacingGameEvent;
import racingcar.view.InputView;
import racingcar.vo.RacingPreference;

public class RacingCarController {

    public static void gameStart() {
        InputView inputView = new InputView();
        RacingPreference racingPreference = inputView.startInfo();

        RacingGameEvent racingGameEvent = new RacingGameEvent(racingPreference.getCars());
        racingGameEvent.startEvent(racingPreference.getAttempt());
    }
}
