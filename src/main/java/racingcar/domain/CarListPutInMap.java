package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class CarListPutInMap {
    private final LinkedHashMap<String, Integer> carMap = new LinkedHashMap<>();
    Exception exception = new Exception();

    public void carListPutInMap(List<String> carList) {
        carList.forEach((car) -> {
            exception.checkExcessCarName(car);
            exception.checkOverlapCarName(car);
            carMap.put(car, 0);
        });
        RacingValue.racingStatus = carMap;
    }
}