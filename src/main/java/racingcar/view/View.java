package racingcar.view;

import java.util.List;
import racingcar.dto.RacingGameStatus;
import racingcar.dto.WinnerNames;

public interface View {
    List<String> getCarNames();

    int getRaceCount();

    void showRacingGameStatus(RacingGameStatus racingGameStatus);

    void showWinnerNames(WinnerNames winnerNames);
}
