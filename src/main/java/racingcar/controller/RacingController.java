package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {

    private RacingController() {}

    private static class RacingControllerCreater {
        private static final RacingController INSTANCE = new RacingController();
    }

    public static RacingController getInstance() {
        return RacingControllerCreater.INSTANCE;
    }

    private final static InputView inputView = InputView.getInstance();
    private final static RacingService racingService = RacingService.getInstance();

    public void startGame() {
        inputView.startGame();
    }

    public void startRound(List<String> carNames, int tryCount) {
        racingService.startRound(carNames,tryCount);
    }
}
