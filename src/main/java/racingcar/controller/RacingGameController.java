package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.service.RefereeService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void runRacingGame() {
        RacingGameService racingGameService = new RacingGameService(new InputView(), new OutputView(),
                new RefereeService());
        racingGameService.run();
    }


}
