package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingService = new RacingService();
    }

    public void start() {
        inputView.printRequestCarName();
        List<String> carNames = racingService.saveCarNames(Console.readLine());
        inputView.printRequestAttemptsNumber();
        racingService.saveAttemptNumber(Console.readLine());
        outputView.printRacingStartMessage();
        while(racingService.isContinue()) {
            outputView.printRoundResult(carNames, racingService.race());
        }
        outputView.printWinner(racingService.getWinners());
    }
}
