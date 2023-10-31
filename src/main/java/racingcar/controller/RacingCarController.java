package racingcar.controller;

import racingcar.model.RacingGameEvent;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.vo.RacingPreference;

public class RacingCarController {

    public static void gameStart() {
        InputView inputView = new InputView();
        RacingPreference racingPreference = inputView.startInfo();

        RacingGameEvent racingGameEvent = new RacingGameEvent(racingPreference.getCars());
        racingGameEvent.startEvent(racingPreference.getAttempt());

        ResultView resultView = new ResultView();
        resultView.RacingResult(racingGameEvent.getPositionHistory(), racingPreference.getAttempt());
        resultView.showRacingWinners(racingGameEvent.getWinnerNames(racingGameEvent.getPositionHistory()));
    }
}
