package racingcar.service;

import java.util.List;

public interface RacingService<T> {
    void gameProgress();
    List<T> chooseWinner();
    void gameResult(List<T> winners);
}
