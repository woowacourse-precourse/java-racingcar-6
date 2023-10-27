package racingcar;

import java.util.List;
import java.util.Map;

public interface GameItem {
    void carMove(int attemptsNumber, OutputImpl print);
    List<String> checkWinner();
    Map<String, Integer> carPosition();
}
