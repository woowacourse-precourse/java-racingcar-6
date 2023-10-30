package racingcar.view;

import java.util.List;
import racingcar.domain.RacingGameStatus;
import racingcar.domain.WinnerNames;

public interface View {
    List<String> getCarNames();

    int getRacingCount();

    void showRacingGameStatus(RacingGameStatus racingGameStatus);

    void showWinnerNames(WinnerNames winnerNames);
}
