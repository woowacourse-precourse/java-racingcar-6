package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.domain.Car;

public class StatusResponse {

    private final LinkedHashMap<String, Integer> status = new LinkedHashMap<>();

    public StatusResponse(List<Car> cars) {
        for (Car car : cars) {
            status.put(car.getName(), car.getLocation());
        }
    }

    public LinkedHashMap<String, Integer> getStatus() {
        return status;
    }
}
