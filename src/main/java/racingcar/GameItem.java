package racingcar;

import java.util.List;
import java.util.Map;

public interface GameItem {
    void carMove();
    List<String> checkWinner();
    Map<String, Integer> carPostion();
}
