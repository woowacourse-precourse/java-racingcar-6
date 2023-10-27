package racingcar.controller;

import racingcar.model.RacingCarGameService;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {

    private RacingCarGameView racingCarGameView;
    private RacingCarGameService racingCarGameService;

    public RacingCarGameController() {
        racingCarGameView = new RacingCarGameView();
        racingCarGameService = new RacingCarGameService();
    }

    public void gameStart() {
        racingCarGameView.inputCarNames();
    }
}
