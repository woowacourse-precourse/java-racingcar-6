package racingcar.service;

import java.util.List;
import racingcar.domain.RacingGame;

public interface RacingGameService {
    RacingGame createNewGame(List<Long> carsIdList, int maxGameCount, Long id);

    void join(RacingGame racingGame);

    List<Long> getWinningCarsId(Long Id);

    RacingGame findGameById(Long id);

    boolean isMoveableForwardByRandomNumber();

    boolean isGameFinish(Long id);

    void addGameCount(Long id);
}
