package racingcar.model;

import racingcar.enums.CarType;

import java.util.EnumMap;
import java.util.Map;

public class PlayResult {
    private final Map<CarType, String> result = new EnumMap<>(CarType.class);

    public void put(CarType carType, String string) {
        result.put(carType, string);
    }

    public String get(CarType carType) {
        return result.get(carType);
    }
}
