package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarName {
    private static final Map<String, Integer> carMap = new HashMap<>();

    public void setCarList(List<String> carList) {
        carList.forEach((car) -> {
            carMap.put(car, 0);
        });
    }

    public Map<String, Integer> getCarList() {
        return carMap;
    }
}