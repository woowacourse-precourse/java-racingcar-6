package racingcar;

import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingGame;

import java.util.List;

public class RacingSimulator {
    //레이싱 게임 반복 실행 기능 추가 예정

    private final InputView inputView;
    private final OutputView outputView;

    public RacingSimulator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    // 반복기능 넣기
    private RacingGame createRacingGame(NumberGenerator numberGenerator) {
        List<String> carNames = inputView.inputCarNames();
        int maxTryCount = inputView.inputMaxTryCount();
        return new RacingGame(maxTryCount, numberGenerator, carNames);
    }
}
