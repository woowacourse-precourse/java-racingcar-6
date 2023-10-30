package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private static final RacingcarController instance = new RacingcarController();

    public static RacingcarController getInstance() {
        return instance;
    }

    private RacingcarController() {
    }

    private final RacingCarService racingCarService = RacingCarService.getInstance();

    public void run() {
        OutputView.printStartMessage();
        List<String> carNames = InputView.getCarNames();
        HashMap<String, Integer> racingStatus = racingCarService.initRacingStatus(carNames);
        OutputView.printInputAttemptMessage();
        int attemptNumber = InputView.getAttemptNumber();
        for (int i = 0; i < attemptNumber; ++i) {
            racingCarService.proceedGame(carNames, racingStatus);
            OutputView.printProceedResult(carNames, racingStatus);
        }
        List<String> winnerList = racingCarService.getWinner(carNames, racingStatus);
        OutputView.printWinner(winnerList);
    }
}
