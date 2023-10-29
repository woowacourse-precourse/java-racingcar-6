package racingcar;

import racingcar.entity.GameInfo;

public interface Game {
    void start();

    void getResult();

    void setGameInfo(GameInfo gameInfo);
}
