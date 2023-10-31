package racingcar;

import java.util.LinkedHashMap;
import java.util.List;

public interface Setting {
    void setGame();
    List<String> getRunnerMap();
    LinkedHashMap<String, String> getGameInfoMap();

}