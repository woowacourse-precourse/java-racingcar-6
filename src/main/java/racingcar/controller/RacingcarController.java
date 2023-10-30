package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.view.MainView;

public class RacingcarController {
    private static final RacingcarController instance = new RacingcarController();

    public static RacingcarController getInstance() {
        return instance;
    }

    private RacingcarController() {
    }

    private RacingCarService racingCarService = RacingCarService.getInstance();

    public void run() {
        MainView.printStartMessage();
        List<String> carNames = MainView.getCarNames();
        HashMap<String, Integer> racingStatus = racingCarService.initRacingStatus(carNames);
        MainView.printInputAttemptMessage();
        int attemptNumber = MainView.getAttemptNumber();
        for (int i = 0; i < attemptNumber; ++i) {
            racingCarService.proceedGame(carNames, racingStatus);
            MainView.printProceedResult(carNames, racingStatus);
        }
    }
}
