package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarListPutInMap {
    private static final Map<String, Integer> carMap = new HashMap<>();
    Exception exception = new Exception();

    public void carListPutInMap(List<String> carList) {
        carList.forEach((car) -> {
            exception.IllegalArgumentException(car);
            carMap.put(car, 0);
        });
        RacingValue allValue = new RacingValue();
        allValue.racingStatus = carMap;
    }
}