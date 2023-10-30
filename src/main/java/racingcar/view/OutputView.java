package racingcar.view;

import racingcar.domain.RacingGameStatus;

public interface OutputView {
    void requestCarNames(String delimiterDescription, String delimiter);

    void requestTryCount();

    void printRacingGameStatus(RacingGameStatus racingGameStatus);
}
