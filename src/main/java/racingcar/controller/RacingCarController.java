package racingcar.controller;

import java.util.List;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGameService racingGameService = new RacingGameService();

    public void run() {
        init();
        play();
    }

    public void init() {
        List<String> carNames = inputView.parseCarNames(inputView.inputCarNames());
        int gameCount = inputView.parseMoveCount(inputView.inputMoveCount());
        racingGameService.initializeGameInfo(carNames, gameCount);
    }

    public void play() {
        System.out.println();
        System.out.println("실행 결과");
        while (!racingGameService.finishGame()) {
            racingGameService.tryGame();
            outputView.printResult(racingGameService.getResult());
        }
        outputView.printWinners(racingGameService.getWinners());
    }
}
