package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum GameElements { // 싱글톤 패턴 말고 다른 방법 생각, record도 생각
    INSTANCE;

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
        carNameList.addAll(carNameListByUser);
    }

    public void tryCountSetting(int tryCountByUser) {
        tryCount = tryCountByUser;
    }

    public void carMapSetting() {
        for (String carName : carNameList) {
            carMap.put(carName, 0);
        }
    }

}
