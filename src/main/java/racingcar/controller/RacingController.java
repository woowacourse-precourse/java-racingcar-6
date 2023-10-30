package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Console;


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
        racingService.saveCarNames(Console.readLine());
        inputView.printRequestAttemptsNumber();
        racingService.saveAttemptNumber(Console.readLine());
        outputView.printRacingStartMessage();
    }
}
