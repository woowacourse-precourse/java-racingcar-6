package racingcar.view;

import java.util.List;
import racingcar.domain.RacingGameStatus;

public interface View {
    List<String> getCarNames();

    int getRacingCount();

    void showRacingGameStatus(RacingGameStatus racingGameStatus);
}
