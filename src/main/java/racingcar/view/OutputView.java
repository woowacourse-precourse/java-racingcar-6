package racingcar.view;

import racingcar.domain.RacingGameStatus;
import racingcar.domain.WinnerNames;

public interface OutputView {
    void requestCarNames(String delimiterDescription, String delimiter);

    void requestTryCount();

    void printRacingGameStatus(RacingGameStatus racingGameStatus);

    void printWinnerNames(WinnerNames winnerNames);
}
