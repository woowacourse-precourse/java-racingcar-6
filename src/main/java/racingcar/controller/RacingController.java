package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void playGame() {
        Racing racing = generateRacing();
        racingService.save(racing);

        boolean isContinue = racingService.racing(racing);

        outputView.outputExcutionResult(racing.getParicipations);
        outputView.outputWinner(racing.getWinners);

        replayGame(isContinue);
    }

    private Racing generateRacing() {
        String carNames = inputView.inputCarNames();
        String tryCount = inputView.inputTryCount();

        return racingService.generateRacing(carNames, tryCount);
    }

    private void replayGame(boolean isContinue) {
        if (isContinue) {
            playGame();
        }
    }
}
