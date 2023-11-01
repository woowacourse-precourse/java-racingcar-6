package racingcar;

import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingGame;

import java.util.List;

public class RacingSimulator {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingSimulator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void simulate(NumberGenerator numberGenerator) {
        //레이싱 게임 반복 실행 기능 추가 예정
        RacingGame racingGame = createRacingGame(numberGenerator);

        outputView.printExecuteResultMessage();
        while (!racingGame.isFinished()) {
            racingGame.moveCars();
            outputView.printPositions(racingGame.getPositions());
        }
        outputView.printWinners(racingGame.getWinners());
    }

    private RacingGame createRacingGame(NumberGenerator numberGenerator) {
        List<String> carNames = inputView.inputCarNames();
        int maxTryCount = inputView.inputMaxTryCount();
        return new RacingGame(maxTryCount, numberGenerator, carNames);
    }
}
