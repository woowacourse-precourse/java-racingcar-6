package racingcar.view;

import racingcar.dto.RacingGameResult;

public interface OutputView {
    void requestCarNames(String delimiterDescription, String delimiter);

    void requestRaceCount();

    void printRacingGameResult(RacingGameResult racingGameResult);
}
