package racingcar.logic;

import java.util.List;

public interface Logic {
    void init();
    void start();
    void run();
    void addRound();
    boolean checkMovable();
    void addWinCount();
    int getWinCount();
    List getWinners();
    List getPlayers();
}
