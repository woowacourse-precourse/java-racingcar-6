package racingcar;

import racingcar.Type.GameType;
import racingcar.domain.GameInfo;

public interface Game {
    void start(GameInfo gameInfo);

    void getResult();

    boolean support(GameType gameType);

}
