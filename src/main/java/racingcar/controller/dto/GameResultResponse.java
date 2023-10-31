package racingcar.controller.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.Vehicle;

public class GameResultResponse {

    private final Map<String, Integer> result;

    private GameResultResponse(final Map<String, Integer> result) {
        this.result = result;
    }

    public static GameResultResponse from(final List<Vehicle> vehicles) {
        Map<String, Integer> result = new LinkedHashMap<>();
        vehicles.forEach(vehicle -> result.put(vehicle.getName(), vehicle.getPosition()));
        return new GameResultResponse(result);
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
