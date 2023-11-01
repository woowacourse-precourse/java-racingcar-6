package racingcar.view;

import racingcar.domain.racing.RacingGame;

public interface OutputView {
    void outputExcutionResult(RacingGame racingGame);

    void outputWinner(RacingGame racingGame);
}
