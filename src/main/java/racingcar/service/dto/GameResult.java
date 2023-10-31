package racingcar.service.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import racingcar.domain.Car;

public record GameResult(
    Map<String, Integer> result

) {

    public GameResult() {
        this(new LinkedHashMap<String, Integer>());
    }

    public void note(Car car) {
        result.put(car.getName(), car.getDistance());
    }

    public int getDistance(String name) {
        return result.get(name);
    }

    public Set<String> getKeySet() {
        return result.keySet();
    }
}
