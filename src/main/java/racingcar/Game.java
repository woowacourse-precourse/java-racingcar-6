package racingcar;

import racingcar.Type.GameType;
import racingcar.entity.GameInfo;

public interface Game {
    void start(GameInfo gameInfo);

    void getResult();

    boolean support(GameType gameType);

}
