package racingcar;

import java.util.List;

public interface Game {
    List<String> getWinners();
    void runStage();
    boolean isFinished();
    String render(RacingCarGameRenderer renderer);
}
