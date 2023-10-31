package racingcar.service;

import java.util.List;
import racingcar.domain.RacingGame;

public interface RacingGameService {
    RacingGame createNewGame(List<Long> carsIdList, int maxGameCount, Long id);

    List<Long> getWinningCarsId(Long Id);

    boolean isMoveableForwardByRandomNumber();

    boolean isGameFinish(Long id);
}
