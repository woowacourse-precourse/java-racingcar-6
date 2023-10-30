package racingcar.service;

import java.util.List;

public interface Service {
    void moveCars();
    void tryToOff();
    boolean isOver();
    List<String> getResults();
    List<String> getWinnerNames();
}
