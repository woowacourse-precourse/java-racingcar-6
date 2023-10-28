package racingcar.controller;

import racingcar.application.RacingCarService;
import racingcar.domain.GameResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final RacingCarService racingCarService;

    public RacingController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void racing() {
        List<String> names = InputView.readCarName();
        int tryCount = InputView.readTryCount();
        GameResult gameResult = racingCarService.gameStart(names, tryCount);
        OutputView.printGameResult(gameResult);
    }
}
