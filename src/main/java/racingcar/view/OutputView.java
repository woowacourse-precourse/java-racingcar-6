package racingcar.view;

import racingcar.dto.RacingGameStatus;
import racingcar.dto.WinnerNames;

public interface OutputView {
    void requestCarNames(String delimiterDescription, String delimiter);

    void requestRaceCount();

    void printRacingGameStatus(RacingGameStatus racingGameStatus);

    void printWinnerNames(WinnerNames winnerNames);
}
