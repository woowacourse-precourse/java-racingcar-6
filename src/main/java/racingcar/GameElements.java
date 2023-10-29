package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameElements {
    private List<String> carNameList = new ArrayList<>();
    private int tryCount = 0;

    private Map<String, Integer> carMap = new HashMap<>();

    public List<String> getCarNameList() {
        return carNameList;
    }

    public int getTryCount() {
        return tryCount;
    }

    public Map<String, Integer> getCarMap() {
        return carMap;
    }

    public void carNamesSetting(List<String> carNameListByUser) {
        carNameList = carNameListByUser;
    }

    public void tryCountSetting(int tryCountByUser) {
        tryCount = tryCountByUser;
    }
}
