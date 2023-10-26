package racingcar.controller.dto;

import java.util.Map;
import racingcar.model.Position;
import racingcar.model.Vehicle;

public class GameResultResponse {

    private final Map<Vehicle, Position> map;

    private GameResultResponse(final Map<Vehicle, Position> map) {
        this.map = map;
    }

    public static GameResultResponse from(final Map<Vehicle, Position> map) {
        return new GameResultResponse(map);
    }

    public Map<Vehicle, Position> getMap() {
        return map;
    }
}
