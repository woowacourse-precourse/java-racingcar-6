package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.Game;

public interface RacingCarService {
    void moveCars(Game game);

    List<String> getWinner(Game game);
}
