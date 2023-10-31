package racingcar.model;

import racingcar.enums.CarType;

import java.util.EnumMap;
import java.util.Map;

public class PlayResult {
    private final Map<CarType, String> result = new EnumMap<>(CarType.class);

    public PlayResult (Car car) {
        result.put(CarType.CAR_NAME,car.getName());
        result.put(CarType.DISTANCE,car.getDistance());
    }

    public String get(CarType carType) {
        return result.get(carType);
    }
}
