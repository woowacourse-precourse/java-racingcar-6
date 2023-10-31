package racingcar;

import java.util.List;

public interface Game {
    void runStage();
    void printStage();
    void printResult();
    boolean isFinished();
    String render();
}
