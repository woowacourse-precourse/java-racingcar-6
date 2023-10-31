package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void playGame() {
        RacingGame racingGame = generateRacing();

        racingGameService.decideRandomMoveCondition(racingGame);
        racingGameService.calculateWinners(racingGame);

        outputView.outputExcutionResult(racingGame.getParticipationsList()); //출력은 outputView 담당
        outputView.outputWinner(racingGame.getWinnerList());

        replayGame(false); //추후 게임을 여러번 할때 사용 가능한 기능
    }

    private RacingGame generateRacing() {
        String carNames = inputView.inputCarNames();
        String tryCount = inputView.inputTryCount();

        return racingGameService.generateRacing(carNames, tryCount);
    }

    private void replayGame(boolean isContinue) {
        if (isContinue) {
            playGame();
        }
    }
}
