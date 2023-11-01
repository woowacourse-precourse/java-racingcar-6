package game;

import java.util.List;

public interface Game {
    boolean isFinished();
    void runStage();
    void printStage();
    void printResult();
    String render();
}
