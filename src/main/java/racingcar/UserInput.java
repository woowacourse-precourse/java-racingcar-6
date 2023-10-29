package racingcar;

import racingcar.entity.GameInfo;

public interface UserInput {
    String inputLine();

    int inputAttemptNum();

    GameInfo getGameInfo();
}
