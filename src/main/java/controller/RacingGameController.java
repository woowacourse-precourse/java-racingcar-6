package controller;

import controller.dto.CarNames;
import controller.dto.MoveResult;
import java.util.List;
import model.TryCount;
import service.RacingService;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private RacingService racingService;
    private TryCount tryCount;

    public RacingGameController(final OutputView outputView, final InputView inputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
        startRace();
        decideWinner();
    }

    private void initGame() {
        initService();
        initTryCount();
    }

    private void startRace() {
        outputView.informBeforeShowMove();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            List<MoveResult> moveResults = racingService.moveEachCar();
            outputView.informResult(moveResults);
        }
    }

    private void decideWinner() {
        List<String> decidedWinners = racingService.getWinners();
        outputView.showWinners(decidedWinners);
    }

    private void initService() {
        outputView.askCarNames();
        CarNames carNames = CarNames.of(inputView.readLine());
        racingService = RacingService.createDefault(carNames.getCarNames());
    }

    private void initTryCount() {
        outputView.askTryCount();
        tryCount = TryCount.from(inputView.readLine());
    }
}
