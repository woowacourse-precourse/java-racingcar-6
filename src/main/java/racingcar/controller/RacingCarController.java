package racingcar.controller;

import java.util.List;
import racingcar.dto.CarResultResponse;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int gamePlayCount = startGame();
        playGame(gamePlayCount);
        endGame();
    }

    private int startGame() {
        outputView.printGameStartMessage();
        List<String> carNames = inputView.inputCarNames();
        racingCarService.save(carNames);
        return getGamePlayCount();
    }

    private int getGamePlayCount() {
        outputView.printInputGameProgressCountMessage();
        return inputView.inputGamePlayCount();
    }

    private void playGame(int gamePlayCount) {
        outputView.printGameProcessMessage();
        for (int count = 0; count < gamePlayCount; count++) {
            List<CarResultResponse> carResultResponses = racingCarService.processMove();
            outputView.printGameProcessResult(carResultResponses);
        }
    }

    private void endGame() {
        List<String> winnerNames = racingCarService.getWinnerNames();
        outputView.printGameWinners(winnerNames);
    }
}
