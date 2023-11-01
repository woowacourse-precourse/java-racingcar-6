package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
    private final static OutputView outputView = OutputView.getInstance();
    private final static RacingService racingService = RacingService.getInstance();

    public void startGame() {
        inputView.startGame();
    }

    public void startRound(List<String> carNames, int tryCount) {
        racingService.startRound(carNames,tryCount);
        processRound(tryCount);
    }

    public void processRound(int totalRound) {
        for (int round=1; round<=totalRound; round++) {
            List<Car> cars = racingService.processRound();
            outputView.printRoundResult(round,totalRound,cars);
        }
    }

    public void decideWinner() {
        List<Car> winners = racingService.decideWinner();
        // TODO: output view 에서 우승자 출력
    }
}
