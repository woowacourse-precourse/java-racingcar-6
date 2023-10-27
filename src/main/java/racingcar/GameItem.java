package racingcar;

import java.util.List;
import java.util.Map;

public interface GameItem {
    void carMove(int attemptsNumber, PrintImpl print);
    List<String> checkWinner();
    Map<String, Integer> carPosition();
}
