package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * RacingGameController 클래스는 경주 게임의 흐름을 제어합니다.
 */
public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    /**
     * RacingGameController의 생성자입니다.
     *
     * @param inputView         사용자에게 입력을 받는 InputView 인스턴스
     * @param outputView        결과를 출력하는 OutputView 인스턴스
     * @param racingGameService 레이싱 게임 비지니스 로직을 관리하는 RacingGameService 인스턴스
     */
    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    /**
     * 게임을 실행하는 메소드입니다.
     * 사용자에게 입력을 받고, 랜덤 값을 부여하고, 우승자를 계산하고, 결과를 출력합니다.
     * 게임을 재시작할 때 replayGame(boolean)에 true값을 보내면 게임이 재실행됩니다. 현재는 사용하지 않는 기능입니다.
     */
    public void playGame() {
        RacingGame racingGame = generateRacing();

        racingGameService.decideRandomMoveCondition(racingGame);
        racingGameService.calculateWinners(racingGame);

        outputView.outputExcutionResult(racingGame);
        outputView.outputWinner(racingGame);

        replayGame(false);
    }

    /**
     * 사용자 입력을 받아 RacingGame 인스턴스를 생성하는 메소드입니다.
     *
     * @return 생성된 RacingGame 인스턴스
     */
    private RacingGame generateRacing() {
        String carNames = inputView.inputCarNames();
        String tryCount = inputView.inputTryCount();

        return racingGameService.generateRacing(carNames, tryCount);
    }

    /**
     * 게임을 다시 플레이하는 메소드입니다.
     *
     * @param isContinue 게임을 계속할지 여부를 나타내는 플래그
     */
    private void replayGame(boolean isContinue) {
        if (isContinue) {
            playGame();
        }
    }
}
