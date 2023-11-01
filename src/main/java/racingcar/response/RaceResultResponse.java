package racingcar.response;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.Car;

public class RaceResultResponse {

    private final Map<String, Integer> currentPosition = new LinkedHashMap<>();

    public Map<String, Integer> getCurrentPositions() {
        return Collections.unmodifiableMap(currentPosition);
    }

    public void updateCarPosition(Car car) {
        currentPosition.put(car.getName(), car.getPosition());
    }
}
