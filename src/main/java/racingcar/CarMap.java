package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CarMap {
    LinkedHashMap<String, Integer> map;
    static ArrayList<String> carList;

    public LinkedHashMap<String, Integer> makeInitMap(Start start) {
        LinkedHashMap<String, Integer> mapInit = new LinkedHashMap<>();
        carList = start.getCarList();
        for (String key : carList) {
            mapInit.put(key, 0);
        }
        this.map = mapInit;

        return map;
    }

    public LinkedHashMap<String, Integer> judgeResult_madeHashMap() {
        RandomValue randomValue = new RandomValue();
        LinkedHashMap<String, Integer> updatedMap = map;

        for (String key : carList) {
            boolean isAdvance = randomValue.forwardDecision();
            if (isAdvance) {
                int value = map.get(key);
                value++;
                updatedMap.put(key, value);
            }

        }
        this.map = updatedMap;
        return updatedMap;
    }
}
