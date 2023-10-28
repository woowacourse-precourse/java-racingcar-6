package racingcar.logic;

import java.util.List;

public interface Logic {
    void init();
    void start();
    void run();
    void nextRound();

    List getPlayers();

}
