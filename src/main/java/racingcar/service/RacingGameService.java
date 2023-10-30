package racingcar.service;

import java.util.List;
import racingcar.domain.RacingGame;

public interface RacingGameService {
    RacingGame createNewGame(List<Long> carsIdList, int maxGameCount);

    boolean isMoveableForwardByRandomNumber();

    List<Long> getWinningCarsId(RacingGame racingGame);
}
